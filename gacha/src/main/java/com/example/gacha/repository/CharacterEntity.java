package com.example.gacha.repository;

import com.example.gacha.model.Character;
import lombok.Data;

@Data
public class CharacterEntity {
    private int id;
    private String name;
    private int lank;

    public Character toCharacter(){
        return new Character(id, name, lank);
    }
}
