package com.tugasakhir.foodordersystem.service.order.impl;

import com.tugasakhir.foodordersystem.builder.CustomBuilder;
import com.tugasakhir.foodordersystem.entity.managementuser.User;
import com.tugasakhir.foodordersystem.entity.master.FotoMakanan;
import com.tugasakhir.foodordersystem.entity.master.MenuMakanan;
import com.tugasakhir.foodordersystem.entity.order.Pesanan;
import com.tugasakhir.foodordersystem.mapper.master.MenuMakananMapper;
import com.tugasakhir.foodordersystem.mapper.oder.PesananMapper;
import com.tugasakhir.foodordersystem.mapper.oder.UbahStatusPesananMapper;
import com.tugasakhir.foodordersystem.model.app.AppPage;
import com.tugasakhir.foodordersystem.model.app.SimpleMap;
import com.tugasakhir.foodordersystem.model.enums.StatusPesanan;
import com.tugasakhir.foodordersystem.model.filter.MenuMakananFilterRecord;
import com.tugasakhir.foodordersystem.model.filter.PesananFilterRecord;
import com.tugasakhir.foodordersystem.model.request.MenuMakananRequestRecord;
import com.tugasakhir.foodordersystem.model.request.PesananRequestRecord;
import com.tugasakhir.foodordersystem.model.request.UbahStatusPesananRequestRecord;
import com.tugasakhir.foodordersystem.repository.managementuser.UserRepository;
import com.tugasakhir.foodordersystem.repository.master.MenuMakananRepository;
import com.tugasakhir.foodordersystem.repository.order.PesananRepository;
import com.tugasakhir.foodordersystem.repository.order.RiwayatTransaksiPemesananRepository;
import com.tugasakhir.foodordersystem.service.master.MenuMakananService;
import com.tugasakhir.foodordersystem.service.order.PesananService;
import com.tugasakhir.foodordersystem.util.FilterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PesananImpl implements PesananService {

    private final PesananRepository pesananRepository;
    private final PesananMapper pesananMapper;
    private final UbahStatusPesananMapper ubahStatusPesananMapper;
    private final UserRepository userRepository;
    private final MenuMakananRepository menuMakananRepository;
    private final RiwayatTransaksiPemesananRepository riwayatTransaksiPemesananRepository;
//    private final PasswordEncoder passwordEncoder;

    @Override
    public void add(PesananRequestRecord request) {

        User user = userRepository.findById(request.idUser())
                .orElseThrow(() -> new RuntimeException("User tidak ditemukan"));

        MenuMakanan menu = menuMakananRepository.findById(request.id_menuMakanan())
                .orElseThrow(() -> new RuntimeException("Menu makanan tidak ditemukan"));

//        if (request.jumlah() > menu.getStok()) {
//            throw new RuntimeException("Stok tidak mencukupi");
//        }
//
//        // Kurangi stok
//        menu.setStok(menu.getStok() - request.jumlah());
//        menuRepository.save(menu);
        var pesanan = pesananMapper.requestToEntity(request, user, menu);
//        user.setPassword(passwordEncoder.encode(request.password()));
        pesananRepository.save(pesanan);
    }

    @Override
    public void edit(PesananRequestRecord request) {
        var pesananExisting = pesananRepository.findById(request.idPesanan()).orElseThrow(() ->  new RuntimeException("Data pesanan tidak ditemukan"));

        User user = userRepository.findById(request.idUser())
                .orElseThrow(() -> new RuntimeException("User tidak ditemukan"));

        MenuMakanan menu = menuMakananRepository.findById(request.id_menuMakanan())
                .orElseThrow(() -> new RuntimeException("Menu makanan tidak ditemukan"));

        if(request.statusPesanan() == StatusPesanan.SUDAH_DIPROSES){
            var ubahstatuspesanan = ubahStatusPesananMapper.requestToEntity(request, user, menu);
            riwayatTransaksiPemesananRepository.save(ubahstatuspesanan);
            pesananRepository.delete(pesananExisting);
        } else{
            var pesanan = pesananMapper.requestToEntity(request, user, menu);
            pesanan.setIdPesanan(pesananExisting.getIdPesanan());
            pesananRepository.save(pesanan);
        }
    }

    @Override
    public Page<SimpleMap> findAll(PesananFilterRecord filterRequest, Pageable pageable) {
        CustomBuilder<Pesanan> builder = new CustomBuilder<>();

        FilterUtil.builderConditionNotBlankLike("idPesanan", filterRequest.idPesanan(), builder);
        FilterUtil.builderConditionNotBlankLike("metodePembayaran", filterRequest.metodePembayaran(), builder);
//        FilterUtil.builderConditionNotBlankLike("username", filterRequest.username(), builder);
//        FilterUtil.builderConditionNotNullEqual("statusUser", filterRequest.statusUser(), builder);
//        FilterUtil.builderConditionNotNullEqual("role", filterRequest.role(), builder);

        Page<Pesanan> listPesanan = pesananRepository.findAll(builder.build(), pageable);
        List<SimpleMap> listData = listPesanan.stream().map(pesanan -> {
            SimpleMap data = new SimpleMap();
            data.put("idPesanan", pesanan.getIdPesanan());
            data.put("nama pemesan", pesanan.getUser().getNama());
            data.put("nama makanan", pesanan.getMenuMakanan().getNama());
            data.put("harga", pesanan.getMenuMakanan().getHarga());
            data.put("jumlah", pesanan.getJumlah());
            data.put("totalHarga", pesanan.getTotalHarga());
            data.put("metode pembayaran", pesanan.getMetodePembayaran());
            data.put("status pesanan", pesanan.getStatusPesanan());
            return data;
        }).toList();

        return AppPage.create(listData, pageable, listPesanan.getTotalElements());
    }

    @Override
    public SimpleMap findById(String id) {

        var pesanan = pesananRepository.findById(id).orElseThrow(() ->  new RuntimeException("Data pesanan tidak ditemukan"));
        var menuMakanan = pesanan.getMenuMakanan();
        var user = pesanan.getUser();

        SimpleMap data = new SimpleMap();

        data.put("ID Pesanan", pesanan.getIdPesanan());
        data.put("Nama Pemesan", user.getNama());
        data.put("Menu Dipesan", menuMakanan.getNama());
        data.put("Harga", menuMakanan.getHarga());
        data.put("Jumlah", pesanan.getJumlah());
        data.put("Total Bayar", pesanan.getTotalHarga());
        data.put("Metode Pembayaran", pesanan.getMetodePembayaran());
        data.put("Status Pesanan", pesanan.getStatusPesanan());
//        data.put("deskripsi", menuMakanan.getDeskripsi());
//        data.put("statusMakanan", menuMakanan.getStatusMakanan().getLabel());
//        data.put("createdDate", menuMakanan.getCreatedDate());
//        data.put("modifiedDate", menuMakanan.getModifiedDate());

        return data;
    }

    @Override
    public void delete(String idPesanan) {
        var pesanan = pesananRepository.findById(idPesanan).orElseThrow(() ->  new RuntimeException("Data pesanan tidak ditemukan"));
        pesananRepository.deleteById(idPesanan);
    }



}
