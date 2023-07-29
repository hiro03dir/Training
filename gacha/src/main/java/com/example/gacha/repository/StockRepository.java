package com.example.gacha.repository;

import com.example.gacha.dto.StockEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockRepository {
    List<CharacterEntity> getUserCharacters(int user_id);
    void save(List<StockEntity> stocks);
}
