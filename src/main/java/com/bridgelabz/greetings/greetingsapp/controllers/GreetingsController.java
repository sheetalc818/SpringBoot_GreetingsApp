package com.bridgelabz.greetings.greetingsapp.controllers;

import com.bridgelabz.greetings.greetingsapp.exceptions.GreetingException;
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

    User user = new User();

    @GetMapping("/get/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @PostMapping("/post/adduser")
    public Greeting greetingGet(@RequestParam(value = "fname") String firstname, @RequestParam(value = "lname")String lastname){
        user.setFirstName(firstname);
        user.setLastName(lastname);
        return greetingService.addGreeting(user);
    }

    @GetMapping("/get/alluser")
    public List<Greeting> getAllGrettings(){
        return greetingService.getAllUser();
    }

    @GetMapping("/get/findbyid")
    public Greeting getUserById(@RequestParam(value = "id")long id) throws GreetingException {
        return greetingService.getGreetingById(id);
    }

    @PutMapping("/put/greeting")
    public ResponseEntity<Greeting> putGreeting(@RequestBody Greeting greeting) {
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

    //localhost:8081/greeting/update/id/?firstName=Sheetal&lastName=Chaudhari
    @PutMapping("/update")
    public String updateGreeting(@RequestParam(value = "id") long id, @RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName) {
        greetingService.UpdateById(id, firstName, lastName);
        return "Greeting Updated Successfully";
    }

    @DeleteMapping("/delete")
    public String deleteGreeting(@RequestParam(value = "id")long id) throws GreetingException {
        greetingService.deleteGreetingById(id);
        return "Greeting deleted Successfully";
    }
}
