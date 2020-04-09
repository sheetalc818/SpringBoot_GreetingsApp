package com.bridgelabz.greetings.greetingsapp.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingsController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue="World") String name){
        return new Greeting(counter.incrementAndGet(),
        String.format(template,name));
    }

    @PostMapping("/postgreeting")
    public String postBodyGreeting(@RequestBody Greeting greeting){
        return greeting.getName() + " " + greeting.getUserId();
    }

    @PutMapping("/putgreeting")
    public ResponseEntity<Greeting> putHello(){
        Greeting newUser = new Greeting();
        newUser.setName("Sheetal");
        newUser.setUserId(2);
        //return  user.getFirstName() + " " + user.getLastName();
        //return "User has been updated"
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
}
