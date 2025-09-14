package com.tugasakhir.foodordersystem.service.app;

import com.tugasakhir.foodordersystem.entity.managementuser.User;
import com.tugasakhir.foodordersystem.model.app.SimpleMap;
import com.tugasakhir.foodordersystem.model.request.LoginRequestRecord;
import com.tugasakhir.foodordersystem.model.request.UserRequestRecord;

public interface AuthService {

    void registrasiAkun(UserRequestRecord request);
    SimpleMap login(LoginRequestRecord request);
    void logout(User userLoggedIn);

}
