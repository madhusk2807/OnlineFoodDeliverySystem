package com.ofds;

public class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}
