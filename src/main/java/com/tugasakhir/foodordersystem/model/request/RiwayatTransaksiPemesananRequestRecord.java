package com.tugasakhir.foodordersystem.model.request;

import com.tugasakhir.foodordersystem.model.enums.MetodePembayaran;
import com.tugasakhir.foodordersystem.model.enums.StatusPesanan;

public record RiwayatTransaksiPemesananRequestRecord(String id_riwayat_transaksi_pemesanan,
                                                     String id_menuMakanan,
                                                     String idUser,
                                                     Long jumlah,
                                                     Long uangBayar,
                                                     Long uangKembali,
                                                     MetodePembayaran metodePembayaran,
                                                     StatusPesanan statusPesanan
                                  ) {
}