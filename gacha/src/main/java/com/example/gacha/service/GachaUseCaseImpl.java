package com.example.gacha.service;

import com.example.gacha.dto.StockEntity;
import com.example.gacha.dto.UserMapper;
import com.example.gacha.model.Character;
import com.example.gacha.model.Gacha;
import com.example.gacha.model.GachaUseCase;
import com.example.gacha.model.User;
import com.example.gacha.repository.CharacterRepository;
import com.example.gacha.repository.StockRepository;
import com.example.gacha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class GachaUseCaseImpl implements GachaUseCase {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Character> getCharacters(){
        // UserNameを取得
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        // Userの取得
        User user = this.userRepository.findByName(username).toUser();
        // Characterの取得
        List<Character> characters = this.characterRepository.getCharacters().stream().map(i ->new Character(i.getId(),i.getName(), i.getLank())).collect(Collectors.toList());

        //ガチャの作成
        Gacha gacha = new Gacha(characters);
        user.useCoin(gacha.needCoins);
        // ガチャの利用
        List<Character> characterList = gacha.play();
        // ユーザー情報の更新
        this.userRepository.updateCoin(this.userMapper.toEntity(user));

        List<StockEntity> stockEntities = characterList.stream().map(i -> {
            return new StockEntity(user.getId(), i.getId());
        }).collect(Collectors.toList());

        this.stockRepository.save(stockEntities);

        return characterList;
    }
}
