package com.tugasakhir.foodordersystem.model.request;

import com.tugasakhir.foodordersystem.model.enums.Role;
import com.tugasakhir.foodordersystem.model.enums.StatusUser;

public record UserRequestRecord(String idUser,
                                String fotoProfil,
                                String nama,
                                String username,
                                String password,
                                String email,
                                String nomorHp,
                                String alamat,
                                StatusUser statusUser,
                                Role role) {
}