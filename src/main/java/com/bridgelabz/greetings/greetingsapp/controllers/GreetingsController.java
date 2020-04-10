package com.bridgelabz.greetings.greetingsapp.controllers;

import com.bridgelabz.greetings.greetingsapp.model.Greeting;
import com.bridgelabz.greetings.greetingsapp.model.User;
import com.bridgelabz.greetings.greetingsapp.services.IGreetingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingsController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingServices greetingService;

    @GetMapping("/get/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @PostMapping("/post/adduser")
    public Greeting greetingGet(@RequestParam(value = "fname") String firstname, @RequestParam(value = "lname")String lastname){
        User user = new User();
        user.setFirstName(firstname);
        user.setLastName(lastname);
        return greetingService.addGreeting(user);
    }

    @GetMapping("/get/alluser")
    public List<Greeting> getAllGrettings(){
        return greetingService.getAllUser();
    }

    @PostMapping("/post/greeting")
    public Greeting greeting(@RequestBody Greeting greeting) {
        return new Greeting(counter.incrementAndGet(), String.format(template, greeting.getMessage()));
    }

    @PutMapping("/put/greeting")
    public ResponseEntity<Greeting> putGreeting(@RequestBody Greeting greeting) {
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
