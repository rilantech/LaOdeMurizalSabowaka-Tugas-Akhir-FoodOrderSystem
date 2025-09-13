package com.tugasakhir.foodordersystem.mapper.oder;

import com.tugasakhir.foodordersystem.entity.managementuser.User;
import com.tugasakhir.foodordersystem.entity.master.MenuMakanan;
import com.tugasakhir.foodordersystem.entity.order.Pesanan;
import com.tugasakhir.foodordersystem.model.request.PesananRequestRecord;
import org.springframework.stereotype.Component;

@Component
public class RiwayatTransaksiPemesananMapper {

    public Pesanan requestToEntity(PesananRequestRecord request, User user, MenuMakanan menuMakanan) {
        return Pesanan.builder()
                .user(user)
                .menuMakanan(menuMakanan)
                .jumlah(request.jumlah())
                .metodePembayaran(request.metodePembayaran())
                .totalHarga(menuMakanan.getHarga()*request.jumlah())
                .statusPesanan(request.statusPesanan())
                .build();
    }

}
