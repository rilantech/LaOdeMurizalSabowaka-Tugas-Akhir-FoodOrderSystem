package com.tugasakhir.foodordersystem.entity.master;

import com.tugasakhir.foodordersystem.entity.app.BaseEntity;
import com.tugasakhir.foodordersystem.model.enums.StatusMakanan;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "m_menuMakanan", indexes = {
        @Index(name = "idx_menuMakanan_created_date", columnList = "createdDate"),
        @Index(name = "idx_menuMakanan_modified_date", columnList = "modifiedDate"),
        @Index(name = "idx_menuMakanan_kategoriMakanan", columnList = "kategoriMakanan"),
        @Index(name = "idx_menuMakanan_nama", columnList = "nama"),
        @Index(name = "idx_menuMakanan_harga", columnList = "harga"),
        @Index(name = "idx_menuMakanan_stok", columnList = "stok"),
        @Index(name = "idx_menuMakanan_deskripsi", columnList = "deskripsi"),
        @Index(name = "idx_menuMakanan_statusMakanan", columnList = "statusMakanan")
})
public class MenuMakanan extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_menuMakanan;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuMakanan", orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private Set<FotoMakanan> listFoto = new HashSet<>();

    @Column(nullable = false, unique = true)
    private String kategoriMakanan;

    @Column(nullable = false, unique = true)
    private String nama;

    @Column(nullable = false)
    private Long harga;

    @Column(nullable = false)
    private Integer stok;

    @Column
    private String deskripsi;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusMakanan statusMakanan;


}