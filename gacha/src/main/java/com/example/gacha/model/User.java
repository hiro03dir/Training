package com.example.gacha.model;

import com.example.gacha.repository.Coin;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ユーザーに関するエンティティ
 */
@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private Coin coin;

    public void useCoin (int pay) {
        if(this.coin.canGacha(pay)) {
            this.coin = this.coin.sub(pay);
        }else {
            // TODO:error
        }
    }
    public void buyCoin(int amt) {
        this.coin = this.coin.add(amt);
    }

    public int getCoin() {
        return this.coin.getAmt();
    }
}
