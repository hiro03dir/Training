package com.example.gacha.service;

import com.example.gacha.model.Character;
import com.example.gacha.model.GachaUseCase;
import com.example.gacha.model.User;
import com.example.gacha.repository.CharacterRepository;
import com.example.gacha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GachaUseCaseImpl implements GachaUseCase {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public List<Character> getCharacters(){
        // Userの取得
        User user = this.userRepository.findByName("zenn").toUser();
        // Characterの取得
        List<Character> characters = this.characterRepository.getCharacters().stream().map(i ->new Character(i.getId(),i.getName(), i.getLank())).collect(Collectors.toList());

        //TODO:ガチャのやりとり
        return characters;
    }
}
