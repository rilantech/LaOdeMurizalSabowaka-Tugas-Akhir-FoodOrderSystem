package com.tugasakhir.foodordersystem.entity.dapur;

import com.tugasakhir.foodordersystem.entity.app.BaseEntity;
import com.tugasakhir.foodordersystem.entity.managementuser.User;
import com.tugasakhir.foodordersystem.entity.master.MenuMakanan;
import com.tugasakhir.foodordersystem.entity.order.Pesanan;
import com.tugasakhir.foodordersystem.model.enums.StatusMasak;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "m_proses_masak", indexes = {
        @Index(name = "idx_riwayat_transaksi_pemesanan_created_date", columnList = "createdDate"),
        @Index(name = "idx_riwayat_transaksi_pemesanan_modified_date", columnList = "modifiedDate"),
        @Index(name = "idx_riwayat_transaksi_pemesanan_id_user", columnList = "id_user"),
        @Index(name = "idx_riwayat_transaksi_pemesanan_id_menu_makanan", columnList = "id_makanan"),
        @Index(name = "idx_riwayat_transaksi_pemesanan_id_pesanan", columnList = "id_pesanan"),
        @Index(name = "idx_riwayat_transaksi_pemesanan_jumlah", columnList = "id_jumlah"),
        @Index(name = "idx_riwayat_transaksi_pemesanan_uang_bayar", columnList = "uang_bayar"),
        @Index(name = "idx_riwayat_transaksi_pemesanan_uang_kembali", columnList = "uang_kembali")
})
public class ProsesMasak extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_prosesMasak;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_menu_makanan", nullable = false)
    private MenuMakanan menuMakanan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pesanan", nullable = false)
    private Pesanan pesanan;

    @Column(nullable = false)
    private LocalDateTime waktu_mulai;

    @Column(nullable = false)
    private LocalDateTime waktu_selesai;

    @Column(nullable = false)
    private StatusMasak statusMasak;
}
