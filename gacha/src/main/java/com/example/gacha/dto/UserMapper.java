package com.example.gacha.dto;

import com.example.gacha.model.User;

public interface UserMapper {
    UserEntity toEntity(User user);
}
