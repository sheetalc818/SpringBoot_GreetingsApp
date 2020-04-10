package com.bridgelabz.greetings.greetingsapp.services;

import com.bridgelabz.greetings.greetingsapp.GreetingException;
import com.bridgelabz.greetings.greetingsapp.model.Greeting;
import com.bridgelabz.greetings.greetingsapp.model.User;

import java.util.List;

public interface IGreetingServices {
    Greeting addGreeting(User user);
    List<Greeting> getAllUser();
    Greeting getGreetingById(long id) throws GreetingException;

    void UpdateById(long id, String firstName, String lastName);

    void deleteGreetingById(long id) throws GreetingException;
}
