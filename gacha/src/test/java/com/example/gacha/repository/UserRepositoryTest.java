package com.example.gacha.repository;

import com.example.gacha.dto.UserEntity;
import com.example.gacha.dto.UserMapper;
import com.example.gacha.dto.UserMapperImpl;
import com.example.gacha.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test_findByName(){
        UserEntity user = this.userRepository.findByName("zenn");
        assertEquals("zenn",user.getName());
    }

    @Test
    public void test_update() {
        UserEntity userEntity = this.userRepository.findByName("zenn");
        assertEquals(900, userEntity.getCoin());
        User user = userEntity.toUser();
        user.useCoin(300);

        // マッパーを利用
        UserEntity afterEntity = this.userMapper.toEntity(user);
        // ここを実装する。
        this.userRepository.updateCoin(afterEntity);

        UserEntity afterUserEntity = this.userRepository.findByName("zenn");
        assertEquals(600, userEntity.getCoin());
    }
}