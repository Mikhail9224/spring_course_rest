package com.maxmelnic.spring.rest.exeption_handing;

public class NoSuchEmployeeExeption extends RuntimeException {
    public NoSuchEmployeeExeption(String message) {
        super(message);
    }
}
