package com.example.gacha.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CharacterRepository {
    List<CharacterEntity> getCharacters();
}
