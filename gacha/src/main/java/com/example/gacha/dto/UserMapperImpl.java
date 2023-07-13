package com.example.gacha.dto;

import com.example.gacha.model.User;

public class UserMapperImpl implements UserMapper{
    @Override
    public UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setCoin(user.getCoin());
        return entity;

    }
}
