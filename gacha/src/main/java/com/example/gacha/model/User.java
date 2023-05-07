package com.example.gacha.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ユーザーに関するエンティティ
 */
@Data
@AllArgsConstructor
public class User {
    private String name;
    private int coin;
}
