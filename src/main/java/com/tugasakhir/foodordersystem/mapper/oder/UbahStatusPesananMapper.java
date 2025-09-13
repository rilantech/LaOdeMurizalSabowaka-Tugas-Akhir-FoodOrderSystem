package com.tugasakhir.foodordersystem.mapper.oder;

import com.tugasakhir.foodordersystem.entity.managementuser.User;
import com.tugasakhir.foodordersystem.entity.master.MenuMakanan;
import com.tugasakhir.foodordersystem.entity.order.Pesanan;
import com.tugasakhir.foodordersystem.entity.order.RiwayatTransaksiPemesanan;
import com.tugasakhir.foodordersystem.model.request.PesananRequestRecord;
import com.tugasakhir.foodordersystem.model.request.UbahStatusPesananRequestRecord;
import org.springframework.stereotype.Component;

@Component
public class UbahStatusPesananMapper {

    public RiwayatTransaksiPemesanan requestToEntity(PesananRequestRecord request, User user, MenuMakanan menuMakanan) {
        return RiwayatTransaksiPemesanan.builder()
                .user(user)
                .menuMakanan(menuMakanan)
                .jumlah(request.jumlah())
                .totalHarga(request.jumlah() * menuMakanan.getHarga())
                .uangBayar(request.uangBayar())
                .uangKembali(request.uangKembali())
                .metodePembayaran(request.metodePembayaran())
                .statusPesanan(request.statusPesanan())
                .build();
    }

}
