package com.tugasakhir.foodordersystem.entity.order;

import com.tugasakhir.foodordersystem.entity.app.BaseEntity;
import com.tugasakhir.foodordersystem.entity.managementuser.User;
import com.tugasakhir.foodordersystem.entity.master.MenuMakanan;
import com.tugasakhir.foodordersystem.model.enums.MetodePembayaran;
import com.tugasakhir.foodordersystem.model.enums.StatusPesanan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "m_riwayat_transaksi_pemesanan", indexes = {
        @Index(name = "idx_riwayat_transaksi_pemesanan_created_date", columnList = "createdDate"),
        @Index(name = "idx_riwayat_transaksi_pemesanan_modified_date", columnList = "modifiedDate"),
        @Index(name = "idx_riwayat_transaksi_pemesanan_id_user", columnList = "idUser"),
        @Index(name = "idx_riwayat_transaksi_pemesanan_id_menu_makanan", columnList = "idMakanan"),
        @Index(name = "idx_riwayat_transaksi_pemesanan_jumlah", columnList = "jumlah"),
        @Index(name = "idx_riwayat_transaksi_pemesanan_total_harga", columnList = "totalHarga"),
        @Index(name = "idx_riwayat_transaksi_pemesanan_uang_bayar", columnList = "uang_bayar"),
        @Index(name = "idx_riwayat_transaksi_pemesanan_uang_kembali", columnList = "uang_kembali"),
        @Index(name = "idx_pesanan_metode_pembayaran", columnList = "metodePembayaran")
})
public class RiwayatTransaksiPemesanan extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_riwayat_transaksi_pemesanan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_menuMakanan", nullable = false)
    private MenuMakanan menuMakanan;

    @Column(nullable = false)
    private Long jumlah;

    @Column(nullable = false)
    private Long totalHarga;

    @Column
    private Long uangBayar;

    @Column
    private Long uangKembali;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MetodePembayaran metodePembayaran;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPesanan statusPesanan;

}
