package com.tugasakhir.foodordersystem.service.order.impl;

import com.tugasakhir.foodordersystem.builder.CustomBuilder;
import com.tugasakhir.foodordersystem.entity.managementuser.User;
import com.tugasakhir.foodordersystem.entity.master.MenuMakanan;
import com.tugasakhir.foodordersystem.entity.order.RiwayatTransaksiPemesanan;
import com.tugasakhir.foodordersystem.mapper.oder.PesananMapper;
import com.tugasakhir.foodordersystem.mapper.oder.UbahStatusPesananMapper;
import com.tugasakhir.foodordersystem.model.app.AppPage;
import com.tugasakhir.foodordersystem.model.app.SimpleMap;
import com.tugasakhir.foodordersystem.model.enums.StatusPesanan;
import com.tugasakhir.foodordersystem.model.filter.RiwayatTransaksiPemesananFilterRecord;
import com.tugasakhir.foodordersystem.model.request.PesananRequestRecord;
import com.tugasakhir.foodordersystem.repository.managementuser.UserRepository;
import com.tugasakhir.foodordersystem.repository.master.MenuMakananRepository;
import com.tugasakhir.foodordersystem.repository.order.PesananRepository;
import com.tugasakhir.foodordersystem.repository.order.RiwayatTransaksiPemesananRepository;
import com.tugasakhir.foodordersystem.service.order.RiwayatTransaksiPemesananService;
import com.tugasakhir.foodordersystem.util.FilterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RiwayatTransaksiPemesananImpl implements RiwayatTransaksiPemesananService {

    private final PesananRepository pesananRepository;
    private final PesananMapper pesananMapper;
    private final UbahStatusPesananMapper ubahStatusPesananMapper;
    private final UserRepository userRepository;
    private final MenuMakananRepository menuMakananRepository;
    private final RiwayatTransaksiPemesananRepository riwayatTransaksiPemesananRepository;
//    private final PasswordEncoder passwordEncoder;

    @Override
    public void add(PesananRequestRecord request) {

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
    public Page<SimpleMap> findAll(RiwayatTransaksiPemesananFilterRecord filterRequest, Pageable pageable) {
        CustomBuilder<RiwayatTransaksiPemesanan> builder = new CustomBuilder<>();

        FilterUtil.builderConditionNotBlankLike("id_riwayat_transaksi_pemesanan", filterRequest.id_riwayat_transaksi_pemesanan(), builder);
        FilterUtil.builderConditionNotBlankLike("metodePembayaran", filterRequest.metodePembayaran(), builder);
//        FilterUtil.builderConditionNotBlankLike("username", filterRequest.username(), builder);
//        FilterUtil.builderConditionNotNullEqual("statusUser", filterRequest.statusUser(), builder);
//        FilterUtil.builderConditionNotNullEqual("role", filterRequest.role(), builder);

        Page<RiwayatTransaksiPemesanan> listTransaksi = riwayatTransaksiPemesananRepository.findAll(builder.build(), pageable);
        List<SimpleMap> listData = listTransaksi.stream().map(transaksi -> {
            SimpleMap data = new SimpleMap();
            data.put("ID Transaksi", transaksi.getId_riwayat_transaksi_pemesanan());
            data.put("nama pemesan", transaksi.getUser().getNama());
            data.put("nama makanan", transaksi.getMenuMakanan().getNama());
            data.put("harga", transaksi.getMenuMakanan().getHarga());
            data.put("jumlah", transaksi.getJumlah());
            data.put("totalHarga", transaksi.getTotalHarga());
            data.put("metode pembayaran", transaksi.getMetodePembayaran());
            data.put("status pemesanan", transaksi.getStatusPesanan());
            return data;
        }).toList();

        return AppPage.create(listData, pageable, listTransaksi.getTotalElements());
    }

    @Override
    public SimpleMap findById(String id) {

        var transaksi = riwayatTransaksiPemesananRepository.findById(id).orElseThrow(() ->  new RuntimeException("Data riwayat transaksi tidak ditemukan"));
        var menuMakanan = transaksi.getMenuMakanan();
        var user = transaksi.getUser();

        SimpleMap data = new SimpleMap();

        data.put("ID Transaksi", transaksi.getId_riwayat_transaksi_pemesanan());
        data.put("nama pemesan", transaksi.getUser().getNama());
        data.put("nama makanan", transaksi.getMenuMakanan().getNama());
        data.put("harga", transaksi.getMenuMakanan().getHarga());
        data.put("jumlah", transaksi.getJumlah());
        data.put("totalHarga", transaksi.getTotalHarga());
        data.put("metode pembayaran", transaksi.getMetodePembayaran());
        data.put("status pemesanan", transaksi.getStatusPesanan());
        return data;
    }

    @Override
    public void delete(String idTransaksi) {
        var transaksi = riwayatTransaksiPemesananRepository.findById(idTransaksi).orElseThrow(() ->  new RuntimeException("Data pesanan tidak ditemukan"));
        pesananRepository.deleteById(idTransaksi);
    }



}
