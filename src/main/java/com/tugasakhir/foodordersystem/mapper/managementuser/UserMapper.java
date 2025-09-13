package com.tugasakhir.foodordersystem.mapper.managementuser;

import com.tugasakhir.foodordersystem.entity.managementuser.User;
import com.tugasakhir.foodordersystem.model.request.UserRequestRecord;
import com.tugasakhir.foodordersystem.service.managementuser.impl.UserServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public User requestToEntity(UserRequestRecord request) {
        return User.builder()
                .fotoProfil(request.fotoProfil())
                .nama(request.nama().toUpperCase())
                .username(request.username().toLowerCase())
                .password(request.password())
                .email(request.email().toLowerCase())
                .nomorHp(request.nomorHp())
                .alamat(request.alamat())
                .statusUser(request.statusUser())
                .role(request.role())
                .build();
    }

}
