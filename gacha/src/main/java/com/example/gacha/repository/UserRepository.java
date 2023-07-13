package com.example.gacha.repository;

import com.example.gacha.dto.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    UserEntity findByName(String name);
    void updateCoin(UserEntity userEntity);
}