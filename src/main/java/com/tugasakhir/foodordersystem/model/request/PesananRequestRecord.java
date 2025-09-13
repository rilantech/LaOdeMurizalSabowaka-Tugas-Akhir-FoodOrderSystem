package com.tugasakhir.foodordersystem.model.request;

import com.tugasakhir.foodordersystem.model.enums.KategoriMakanan;
import com.tugasakhir.foodordersystem.model.enums.MetodePembayaran;
import com.tugasakhir.foodordersystem.model.enums.StatusMakanan;
import com.tugasakhir.foodordersystem.model.enums.StatusPesanan;

import java.util.Set;

public record PesananRequestRecord(String idPesanan,
                                   String id_menuMakanan,
                                   String idUser,
                                   Long jumlah,
                                   Long uangBayar,
                                   Long uangKembali,
                                   MetodePembayaran metodePembayaran,
                                   StatusPesanan statusPesanan
                                  ) {
}