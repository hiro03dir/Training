package com.example.gacha.dto;

import com.example.gacha.model.User;
import lombok.Data;

/**
 * データアクセスのために使われるDTO
 */
@Data
public class UserEntity {
    private int id;
    private String name;
    private String password;
    private int coin;

    public User toUser(){
        return new User(name, coin);
    }
}
