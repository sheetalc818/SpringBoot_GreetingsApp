package com.bridgelabz.greetings.greetingsapp.services.implementation;

import com.bridgelabz.greetings.greetingsapp.model.Greeting;
import com.bridgelabz.greetings.greetingsapp.model.User;
import com.bridgelabz.greetings.greetingsapp.repository.IGreetingRepository;
import com.bridgelabz.greetings.greetingsapp.services.IGreetingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingServices {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = user.toString().isEmpty() ?
                "Hello  World" : user.getFirstName() + " " + user.getLastName();
        Greeting greeting = new Greeting();
        greeting.setId(counter.incrementAndGet());
        greeting.setMessage(message);
        return greetingRepository.save(greeting);
    }

    @Override
    public List<Greeting> getAllUser() {
        return greetingRepository.findAll();
    }
}
