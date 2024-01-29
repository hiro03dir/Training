package com.example.gacha.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Coin {
    private int amt;

    /**
     * コインをマイナス
     * @param sub
     * @return
     */
    public Coin sub(int sub) {
        this.amt -= sub;
        return this;
    }

    /**
     * コインをプラス
     * @param add
     * @return
     */
    public Coin add(int add) {
        this.amt += add;
        return this;
    }

    /**
     * 所持コイン数を返す
     * これはGetterアノテーションで行う
     * @return
     */
//    public int getAmt() {
//        return this.amt;
//    }

    /**
     * ガチャが引けるか判定
     * @param need
     * @return
     */
    public boolean canGacha(int need) {
        if (this.amt - need < 0) {
            return false;
        }
        return true;
    }


}
