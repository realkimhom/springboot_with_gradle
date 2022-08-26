package com.example.demo.exception;

public class IllegalValueException extends Exception {
    public IllegalValueException(String wrong_message){
        super(wrong_message);
    }
    public static void check_max_min(float max, float min) throws IllegalValueException {
        if (min > max){
            throw new IllegalValueException("The min is bigger than max");
        }
    }
}
