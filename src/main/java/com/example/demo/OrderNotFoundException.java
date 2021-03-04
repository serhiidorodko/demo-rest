package com.example.demo;

class OrderNotFoundException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    OrderNotFoundException(Long id) {
        super("Could not found order " + id);
    }
}
