package com.tugasakhir.foodordersystem.service.managementuser.impl;

import com.tugasakhir.foodordersystem.builder.CustomBuilder;
import com.tugasakhir.foodordersystem.entity.managementuser.User;
import com.tugasakhir.foodordersystem.mapper.managementuser.UserMapper;
import com.tugasakhir.foodordersystem.model.app.AppPage;
import com.tugasakhir.foodordersystem.model.app.SimpleMap;
import com.tugasakhir.foodordersystem.model.filter.UserFilterRecord;
import com.tugasakhir.foodordersystem.model.request.UserRequestRecord;
import com.tugasakhir.foodordersystem.repository.managementuser.UserRepository;
import com.tugasakhir.foodordersystem.service.managementuser.UserService;
import com.tugasakhir.foodordersystem.util.FilterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
//    private final PasswordEncoder passwordEncoder;

    @Override
    public void add(UserRequestRecord request) {

        var user = userMapper.requestToEntity(request);
//        user.setPassword(passwordEncoder.encode(request.password()));
        userRepository.save(user);
    }

    @Override
    public void edit(UserRequestRecord request) {

        var userExisting = userRepository.findById(request.idUser()).orElseThrow(() ->  new RuntimeException("Data user tidak ditemukan"));

        var user = userMapper.requestToEntity(request);
        user.setIdUser(userExisting.getIdUser());
//        user.setPassword(passwordEncoder.encode(request.password()));
        userRepository.save(user);
    }

    @Override
    public Page<SimpleMap> findAll(UserFilterRecord filterRequest, Pageable pageable) {
        CustomBuilder<User> builder = new CustomBuilder<>();

        FilterUtil.builderConditionNotBlankLike("nama", filterRequest.nama(), builder);
        FilterUtil.builderConditionNotBlankLike("email", filterRequest.email(), builder);
        FilterUtil.builderConditionNotBlankLike("username", filterRequest.username(), builder);
        FilterUtil.builderConditionNotNullEqual("statusUser", filterRequest.statusUser(), builder);
        FilterUtil.builderConditionNotNullEqual("role", filterRequest.role(), builder);

        Page<User> listUser = userRepository.findAll(builder.build(), pageable);
        List<SimpleMap> listData = listUser.stream().map(user -> {
            SimpleMap data = new SimpleMap();
            data.put("idUser", user.getIdUser());
            data.put("fotoProfil", user.getFotoProfil());
            data.put("nama", user.getNama());
            data.put("username", user.getUsername());
            data.put("email", user.getEmail());
            data.put("nomorHP", user.getNomorHp());
            data.put("alamat", user.getAlamat());
            data.put("role", user.getRole().getLabel());
            data.put("statusUser", user.getStatusUser().getLabel());
            return data;
        }).toList();

        return AppPage.create(listData, pageable, listUser.getTotalElements());
    }

    @Override
    public SimpleMap findById(String id) {
        var user = userRepository.findById(id).orElseThrow(() ->  new RuntimeException("Data user tidak ditemukan"));
        SimpleMap data = new SimpleMap();
        data.put("idUser", user.getIdUser());
        data.put("fotoProfil", user.getFotoProfil());
        data.put("nama", user.getNama());
        data.put("username", user.getUsername());
        data.put("email", user.getEmail());
        data.put("nomorHP", user.getNomorHp());
        data.put("alamat", user.getAlamat());
        data.put("statusUser", user.getStatusUser().getLabel());
        data.put("role", user.getRole().getLabel());
        return data;
    }

    @Override
    public void delete(String idUser) {
        var userExisting = userRepository.findById(idUser).orElseThrow(() ->  new RuntimeException("Data user tidak ditemukan"));
            userRepository.deleteById(idUser);
    }




}
