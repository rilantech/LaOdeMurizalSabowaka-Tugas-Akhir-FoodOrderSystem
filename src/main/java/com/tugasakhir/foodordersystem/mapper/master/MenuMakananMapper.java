package com.tugasakhir.foodordersystem.mapper.master;

import com.tugasakhir.foodordersystem.entity.managementuser.User;
import com.tugasakhir.foodordersystem.entity.master.FotoMakanan;
import com.tugasakhir.foodordersystem.entity.master.MenuMakanan;
import com.tugasakhir.foodordersystem.model.request.MenuMakananRequestRecord;
import com.tugasakhir.foodordersystem.model.request.UserRequestRecord;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MenuMakananMapper {


    public MenuMakanan requestToEntity(MenuMakananRequestRecord request) {
        MenuMakanan menuMakanan =  MenuMakanan.builder()
                .kategoriMakanan(request.kategoriMakanan())
                .nama(request.nama().toUpperCase())
                .harga(request.harga())
                .stok(request.stok())
                .deskripsi(request.deskripsi())
                .statusMakanan(request.statusMakanan())
                .build();

        menuMakanan.setListFoto(request.listFoto().stream()
                .map(path-> FotoMakanan.builder()
                        .path_foto_makanan(path)
                        .menuMakanan(menuMakanan)
                        .build())
                .collect(Collectors.toSet()));

        return menuMakanan;
    }

}
