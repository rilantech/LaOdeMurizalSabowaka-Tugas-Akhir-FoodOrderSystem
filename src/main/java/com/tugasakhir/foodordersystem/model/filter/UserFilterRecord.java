package com.tugasakhir.foodordersystem.model.filter;

import com.tugasakhir.foodordersystem.model.enums.Role;
import com.tugasakhir.foodordersystem.model.enums.StatusUser;

public record UserFilterRecord(String nama,
                               String email,
                               String username,
                               StatusUser statusUser,
                               Role role) {
}