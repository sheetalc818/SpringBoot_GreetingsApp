package com.bridgelabz.greetings.greetingsapp;

public class GreetingException extends Exception {
    public ExceptionType type;

    public enum ExceptionType {
        NO_Id_Exist;
    }
    public GreetingException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
