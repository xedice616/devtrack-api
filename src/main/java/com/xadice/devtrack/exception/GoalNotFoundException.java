package com.xadice.devtrack.exception;

public class GoalNotFoundException extends RuntimeException {

    public GoalNotFoundException(String message) {
        super(message);
    }
}