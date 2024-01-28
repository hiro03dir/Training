package com.example.gacha.repository;

import com.example.gacha.dto.StockEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class StockRepositoryTest {
    @Autowired
    private StockRepository stockRepository;

    @Test
    public void test_duplicates_are_not_registered() {
        // 重複を含むデータをインサート
        List<StockEntity> stocks = List.of(
                new StockEntity(1,2),
                new StockEntity(1,1),
                new StockEntity(1,2)
        );
        this.stockRepository.save(stocks);

        // todo: stockRepoから取得した情報をデータ型変換なしでcharEntitesに詰めていいのか？
        List<CharacterEntity> characterEntities = this.stockRepository.getUserCharacters(1);

        // この時点での登録が2件
        assertEquals(2, characterEntities.size());

        // さらに3件のデータを挿入
        List<StockEntity> stocks2 = List.of(
                new StockEntity(1,2),
                new StockEntity(1,1),
                new StockEntity(1,3)
        );
        this.stockRepository.save(stocks2);
        List<CharacterEntity> characterEntities2 = this.stockRepository.getUserCharacters(1);

        // この時点での登録が3件
        assertEquals(3, characterEntities2.size());
    }
}
