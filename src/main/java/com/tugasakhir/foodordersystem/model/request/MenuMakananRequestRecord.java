package com.tugasakhir.foodordersystem.model.request;

import com.tugasakhir.foodordersystem.model.enums.KategoriMakanan;
import com.tugasakhir.foodordersystem.model.enums.Role;
import com.tugasakhir.foodordersystem.model.enums.StatusMakanan;
import com.tugasakhir.foodordersystem.model.enums.StatusUser;

import java.util.Set;

public record MenuMakananRequestRecord(String id_menuMakanan,
                                       Set<String> listFoto,
                                       KategoriMakanan kategoriMakanan,
                                       String nama,
                                       Long harga,
                                       Integer stok,
                                       String deskripsi,
                                       StatusMakanan statusMakanan) {
}