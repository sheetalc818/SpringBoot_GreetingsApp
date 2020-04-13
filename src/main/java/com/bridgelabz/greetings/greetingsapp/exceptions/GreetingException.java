package com.bridgelabz.greetings.greetingsapp.exceptions;

public class GreetingException extends Exception {
    public ExceptionType type;

    public enum ExceptionType {
        No_Id_Exist;
    }
    public GreetingException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
