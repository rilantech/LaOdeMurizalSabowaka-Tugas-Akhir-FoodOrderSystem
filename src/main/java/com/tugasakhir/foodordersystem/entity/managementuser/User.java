package com.tugasakhir.foodordersystem.entity.managementuser;

import com.tugasakhir.foodordersystem.entity.app.BaseEntity;
import com.tugasakhir.foodordersystem.model.enums.Role;
import com.tugasakhir.foodordersystem.model.enums.StatusUser;
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
@Table(name = "m_user", indexes = {
        @Index(name = "idx_user_created_date", columnList = "createdDate"),
        @Index(name = "idx_user_modified_date", columnList = "modifiedDate"),
        @Index(name = "idx_user_fotoProfil", columnList = "fotoProfil"),
        @Index(name = "idx_user_nama", columnList = "nama"),
        @Index(name = "idx_user_username", columnList = "username"),
        @Index(name = "idx_user_email", columnList = "email"),
        @Index(name = "idx_user_nomorHp", columnList = "nomorHp"),
        @Index(name = "idx_user_alamat", columnList = "alamat"),
        @Index(name = "idx_user_statusUser", columnList = "statusUser"),
        @Index(name = "idx_user_role", columnList = "role")
})
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idUser;

    @Column(nullable = false)
    private String fotoProfil;

    @Column(nullable = false, unique = true)
    private String nama;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String nomorHp;

    @Column(nullable = false)
    private String alamat;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusUser statusUser;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private String token;
    private LocalDateTime expiredTokenAt;

}
