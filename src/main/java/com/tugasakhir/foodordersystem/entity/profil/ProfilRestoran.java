package com.tugasakhir.foodordersystem.entity.profil;


import com.tugasakhir.foodordersystem.entity.app.BaseEntity;
import com.tugasakhir.foodordersystem.entity.managementuser.User;
import com.tugasakhir.foodordersystem.entity.master.FotoMakanan;
import com.tugasakhir.foodordersystem.model.enums.StatusMakanan;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.w3c.dom.Text;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "m_profil_restoran", indexes = {
        @Index(name = "idx_profil_restoran_created_date", columnList = "createdDate"),
        @Index(name = "idx_profil_restoran_modified_date", columnList = "modifiedDate"),
        @Index(name = "idx_profil_restoran_logo", columnList = "logo"),
        @Index(name = "idx_profil_restoran_nama", columnList = "nama"),
        @Index(name = "idx_profil_restoran_nomorHP", columnList = "nomorHP"),
        @Index(name = "idx_profil_restoran_email", columnList = "email"),
        @Index(name = "idx_profil_restoran_alamat", columnList = "alamat"),
        @Index(name = "idx_profil_restoran_deskripsi", columnList = "deskripsi"),
        @Index(name = "idx_profil_restoran_jamBuka", columnList = "jamBuka"),
        @Index(name = "idx_profil_restoran_jamTutup", columnList = "jamTutup"),

})
public class ProfilRestoran extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_profilRestoran;

    @Column(nullable = false)
    private String logo;

    @Column(nullable = false)
    private String nama;

    @Column(nullable = false)
    private String nomorHP;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String alamat;

    @Column(nullable = false)
    private String deskripsi;

    @Column(nullable = false)
    private String jamBuka;

    @Column(nullable = false)
    private String jamTutup;


}
