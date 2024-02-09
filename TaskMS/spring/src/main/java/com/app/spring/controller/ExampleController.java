package com.app.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Spring Bootでの簡単なAPIの実装例
@RestController
@RequestMapping("/api")
public class ExampleController {

    @GetMapping("/greet")
    public ResponseEntity greet(@RequestParam(defaultValue = "World") String name) {
        String greeting = "Hello, " + name + "!";
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
