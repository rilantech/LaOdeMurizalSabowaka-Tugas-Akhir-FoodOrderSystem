package com.tugasakhir.foodordersystem.controller.app;

import com.tugasakhir.foodordersystem.config.UserLoggedInConfig;
import com.tugasakhir.foodordersystem.model.request.LoginRequestRecord;
import com.tugasakhir.foodordersystem.model.request.UserRequestRecord;
import com.tugasakhir.foodordersystem.model.response.BaseResponse;
import com.tugasakhir.foodordersystem.service.app.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@Tag(name = "Auth Api")
public class AuthController {

    private final AuthService authService;

    @PostMapping("registrasi-akun")
    public BaseResponse<?> registrasiAkun(@RequestBody UserRequestRecord request) {
            authService.registrasiAkun(request);
            return BaseResponse.ok("Akun Anda Berhasil Di Buat!", null);
    }

    @PostMapping("login")
    public BaseResponse<?> login(@RequestBody LoginRequestRecord request) {
        return BaseResponse.ok(null, authService.login(request));
    }

    @GetMapping("logout")
    public BaseResponse<?> logout(@AuthenticationPrincipal UserLoggedInConfig userLoggedInConfig) {
        var userLoggedIn = userLoggedInConfig.getUser();
        authService.logout(userLoggedIn);
        return BaseResponse.ok("Berhasil logout", null);
    }

}
