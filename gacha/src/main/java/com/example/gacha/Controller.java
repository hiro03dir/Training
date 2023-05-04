package com.example.gacha;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @PostMapping("/sample")
    public ResultObject post(@RequestBody Form sampleForm){
        int id = sampleForm.getId();
        ResultObject resultObject = new ResultObject();
        resultObject.setName("zenn");
        resultObject.setLank(id); //idが取得できたか確認しているだけ
        return resultObject;
    }
}
