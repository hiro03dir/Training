package com.example.gacha;

import com.example.gacha.dto.UserEntity;
import com.example.gacha.model.User;
import com.example.gacha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/sample")
    @CrossOrigin
    public ResultObject post(@RequestBody Form sampleForm){
        int id = sampleForm.getId();
        ResultObject resultObject = new ResultObject();
        resultObject.setName("zenn");
        resultObject.setLank(id); //idが取得できたか確認しているだけ
        return resultObject;
    }

    @GetMapping("/get")
    public User get() {
        UserEntity user = this.userRepository.findByName("zenn");
        return user.toUser();
    }

    @GetMapping("/api/test")
    public String test(){
        return "認証が成功しています";
    }
}
