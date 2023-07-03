package com.example.gacha.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Gacha {
    public final int needCoins = 300;

    private List<Character> characters = new ArrayList<>();

    // コンストラクタでガチャに景品を設置しているイメージ（引数で渡されたcharactersを上のchatacterのListに入れている）
    public Gacha(List<Character> characters) {
        this.characters.addAll(characters);
    }

    // ランダムに3体取得
    public List<Character> play() {
        Collections.shuffle(this.characters);
        return this.characters.stream().limit(3).collect(Collectors.toList());
    }

}
