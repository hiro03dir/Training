package com.example.gacha.service;

import com.example.gacha.dto.UserEntity;
import com.example.gacha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    // TODO：現状不要と思われる
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserEntity entity = userRepository.findByName(username);
            // 認可（権限を与えること）があればここで設定できる
            // org.springframework.security.core.userdetails.Userにして返却する。Userはユーザー名とパスワードを持ったシンプルなドメインモデル。
            // パスワードエンコーダを利用してパスワードはエンコードをかける
            return new User(entity.getName(), PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(entity.getPassword()), new ArrayList<>());
        } catch (Exception e) {
            throw new UsernameNotFoundException("ユーザーが見つかりません");
        }
    }
}
