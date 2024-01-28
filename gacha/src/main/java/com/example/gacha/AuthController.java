package com.example.gacha;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    /**
     * ログインしていない場合はFilterによって事前にエラーが返される
     * @return
     */
    @GetMapping("/api/islogin")
    public boolean isLogin() {
        return true;
    }
}
