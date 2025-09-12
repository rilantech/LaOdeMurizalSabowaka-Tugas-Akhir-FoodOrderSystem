package com.tugasakhir.foodordersystem.entity.master;

import com.tugasakhir.foodordersystem.entity.app.BaseEntity;
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
@Table(name = "m_foto_makanan", indexes = {
        @Index(name = "idx_foto_makanan_created_date", columnList = "createdDate"),
        @Index(name = "idx_foto_makanan_modified_date", columnList = "modifiedDate"),
        @Index(name = "idx_foto_makanan_id_makanan", columnList = "id_makanan"),
        @Index(name = "idx_foto_makanan_path_fotomakanan", columnList = "path_fotomakanan")
})
public class FotoMakanan extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_fotoMakanan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_menu_makanan", nullable = false)
    private MenuMakanan menuMakanan;

    @Column(nullable = false)
    private String pathFotomakanan;

}
