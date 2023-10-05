package com.turkcell.spring.first.business.exceptions;

public class BusinessException extends RuntimeException{

    public BusinessException(String message) {
        super(message);
    }

}
