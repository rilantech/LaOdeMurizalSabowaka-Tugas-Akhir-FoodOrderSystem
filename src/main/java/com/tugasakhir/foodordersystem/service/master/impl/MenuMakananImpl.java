package com.tugasakhir.foodordersystem.service.master.impl;

import com.tugasakhir.foodordersystem.builder.CustomBuilder;
import com.tugasakhir.foodordersystem.entity.managementuser.User;
import com.tugasakhir.foodordersystem.entity.master.FotoMakanan;
import com.tugasakhir.foodordersystem.entity.master.MenuMakanan;
import com.tugasakhir.foodordersystem.mapper.managementuser.UserMapper;
import com.tugasakhir.foodordersystem.mapper.master.MenuMakananMapper;
import com.tugasakhir.foodordersystem.model.app.AppPage;
import com.tugasakhir.foodordersystem.model.app.SimpleMap;
import com.tugasakhir.foodordersystem.model.filter.MenuMakananFilterRecord;
import com.tugasakhir.foodordersystem.model.filter.UserFilterRecord;
import com.tugasakhir.foodordersystem.model.request.MenuMakananRequestRecord;
import com.tugasakhir.foodordersystem.model.request.UserRequestRecord;
import com.tugasakhir.foodordersystem.repository.managementuser.UserRepository;
import com.tugasakhir.foodordersystem.repository.master.MenuMakananRepository;
import com.tugasakhir.foodordersystem.service.managementuser.UserService;
import com.tugasakhir.foodordersystem.service.master.MenuMakananService;
import com.tugasakhir.foodordersystem.util.FilterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuMakananImpl implements MenuMakananService {

    private final MenuMakananRepository menuMakananRepository;
    private final MenuMakananMapper menuMakananMapper;
//    private final PasswordEncoder passwordEncoder;

    @Override
    public void add(MenuMakananRequestRecord request) {

        var menuMakanan = menuMakananMapper.requestToEntity(request);
//        user.setPassword(passwordEncoder.encode(request.password()));
        menuMakananRepository.save(menuMakanan);
    }

    @Override
    public void edit(MenuMakananRequestRecord request) {

        var userExisting = menuMakananRepository.findById(request.id_menuMakanan()).orElseThrow(() ->  new RuntimeException("Data user tidak ditemukan"));

        var menuMakanan = menuMakananMapper.requestToEntity(request);
        menuMakanan.setId_menuMakanan(userExisting.getId_menuMakanan());
//        user.setPassword(passwordEncoder.encode(request.password()));
        menuMakananRepository.save(menuMakanan);
    }

    @Override
    public Page<SimpleMap> findAll(MenuMakananFilterRecord filterRequest, Pageable pageable) {
        CustomBuilder<MenuMakanan> builder = new CustomBuilder<>();

        FilterUtil.builderConditionNotBlankLike("nama", filterRequest.nama(), builder);
//        FilterUtil.builderConditionNotBlankLike("email", filterRequest.email(), builder);
//        FilterUtil.builderConditionNotBlankLike("username", filterRequest.username(), builder);
//        FilterUtil.builderConditionNotNullEqual("statusUser", filterRequest.statusUser(), builder);
//        FilterUtil.builderConditionNotNullEqual("role", filterRequest.role(), builder);

        Page<MenuMakanan> listMenuMakanan = menuMakananRepository.findAll(builder.build(), pageable);
        List<SimpleMap> listData = listMenuMakanan.stream().map(menuMakanan -> {
            SimpleMap data = new SimpleMap();
            data.put("id_menuMakanan", menuMakanan.getId_menuMakanan());
            data.put("listFoto", menuMakanan.getListFoto().stream().map(FotoMakanan::getPath_foto_makanan).collect(Collectors.toSet()));
            data.put("kategoriMakanan", menuMakanan.getStatusMakanan());
            data.put("nama", menuMakanan.getNama());
            data.put("harga", menuMakanan.getHarga());
            data.put("stok", menuMakanan.getStok());
            data.put("deskripsi", menuMakanan.getDeskripsi());
            data.put("statusMakanan", menuMakanan.getStatusMakanan().getLabel());
            data.put("createdDate", menuMakanan.getCreatedDate());
            data.put("modifiedDate", menuMakanan.getModifiedDate());

            return data;
        }).toList();

        return AppPage.create(listData, pageable, listMenuMakanan.getTotalElements());
    }

    @Override
    public SimpleMap findById(String id) {
        var menuMakanan = menuMakananRepository.findById(id).orElseThrow(() ->  new RuntimeException("Data menu makanan tidak ditemukan"));
        SimpleMap data = new SimpleMap();
        data.put("id_menu_Makanan", menuMakanan.getId_menuMakanan());
        data.put("listFoto", menuMakanan.getListFoto().stream().map(FotoMakanan::getPath_foto_makanan).collect(Collectors.toSet()));
        data.put("kategoriMakanan", menuMakanan.getStatusMakanan());
        data.put("nama", menuMakanan.getNama());
        data.put("harga", menuMakanan.getHarga());
        data.put("stok", menuMakanan.getStok());
        data.put("deskripsi", menuMakanan.getDeskripsi());
        data.put("statusMakanan", menuMakanan.getStatusMakanan().getLabel());
        data.put("createdDate", menuMakanan.getCreatedDate());
        data.put("modifiedDate", menuMakanan.getModifiedDate());

        return data;
    }

    @Override
    public void delete(String id) {
        var userExisting = menuMakananRepository.findById(id).orElseThrow(() ->  new RuntimeException("Data menu makanan tidak ditemukan"));
            menuMakananRepository.deleteById(id);
    }




}
