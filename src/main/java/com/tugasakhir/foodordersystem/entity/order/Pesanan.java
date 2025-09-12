package com.tugasakhir.foodordersystem.entity.order;

import com.tugasakhir.foodordersystem.entity.app.BaseEntity;
import com.tugasakhir.foodordersystem.entity.managementuser.User;
import com.tugasakhir.foodordersystem.entity.master.MenuMakanan;
import com.tugasakhir.foodordersystem.model.enums.StatusMakanan;
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
@Table(name = "m_pesanan", indexes = {
        @Index(name = "idx_pesanan_created_date", columnList = "createdDate"),
        @Index(name = "idx_pesanan_modified_date", columnList = "modifiedDate"),
        @Index(name = "idx_pesanan_id_user", columnList = "id_user"),
        @Index(name = "idx_pesanan_id_menu_makanan", columnList = "id_makanan"),
        @Index(name = "idx_pesanan_jumlah", columnList = "id_jumlah"),
        @Index(name = "idx_pesanan_metodePembayaran", columnList = "imetodePembayaran")
})
public class Pesanan extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idPesanan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_menu_makanan", nullable = false)
    private MenuMakanan menuMakanan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;


    @Column(nullable = false)
    private Long jumlah;

    @Column(nullable = false)
    private String metodePembayaran;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPesanan statusPesanan;

}

