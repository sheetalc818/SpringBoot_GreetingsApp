package com.bridgelabz.greetings.greetingsapp.Controllers;

public class Greeting {
    private  String name;
    private  long userId;

    public Greeting() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Greeting(long userId, String message) {
        this.name = message;
        this.userId = userId;
    }
}
