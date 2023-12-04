package com.gammaacademy.gamma.games.api.handler;


public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}