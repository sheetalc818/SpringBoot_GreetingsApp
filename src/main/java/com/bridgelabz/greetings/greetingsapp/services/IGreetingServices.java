package com.bridgelabz.greetings.greetingsapp.services;

import com.bridgelabz.greetings.greetingsapp.model.Greeting;
import com.bridgelabz.greetings.greetingsapp.model.User;

import java.util.List;

public interface IGreetingServices {
    Greeting addGreeting(User user);
    List<Greeting> getAllUser();
}
