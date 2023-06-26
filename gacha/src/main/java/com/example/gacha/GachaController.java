package com.example.gacha;

import com.example.gacha.model.GachaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.gacha.model.Character;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GachaController {

    @Autowired
    private GachaUseCase gachaUseCase;

    @PostMapping("/api/playgacha")
    public List<CharacterOut> play() {
        List<Character> characters = this.gachaUseCase.getCharacters();
        List<CharacterOut> characterOuts = characters.stream().map(CharacterMapper::toOut).collect(Collectors.toList());
        return characterOuts;
    }

    /**
     * 返却オブジェクト
     */
    @AllArgsConstructor
    public static class CharacterOut {
        public String name;

        public static CharacterOut by(String name) {
            return new CharacterOut(name);
        }
    }

    /**
     * CharacterをCharacterOutに変換
     */
    public static class CharacterMapper{
        static CharacterOut toOut(Character character) {
            return CharacterOut.by(character.getName());
        }
    }

}
