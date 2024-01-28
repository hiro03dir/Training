package com.example.gacha.model;

import lombok.Value;

@Value
public class ErrorResponse {
    String errorCode;
    String message;
}
