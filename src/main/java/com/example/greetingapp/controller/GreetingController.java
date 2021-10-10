package com.example.greetingapp.controller;

import com.example.greetingapp.dto.GreetingDTO;
import com.example.greetingapp.entity.GreetingEntity;
import com.example.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/greeting")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping(value = "/greetingMessage")
    public String Greeting() {
        return greetingService.getGreetingMessage();
    }

    @GetMapping(value = {"", "/", "/greetingWithName"})
    public String helloMessage(@RequestParam(value = "firstName", defaultValue = "HelloWorld!") String firstName,
                               @RequestParam(value = "lastName", defaultValue = "HelloWorld!") String lastName) {
        return greetingService.getGreetingWithName(firstName, lastName);
    }

    @PostMapping(value = "/addGreeting")
    public GreetingEntity addGreet(@RequestBody GreetingDTO greetingDTO) {
        return greetingService.addGreeting(greetingDTO);
    }

    @GetMapping(value = "/getMessageByID")
    public GreetingEntity getMessageByID(@RequestParam int id) {
        return greetingService.getMessageByID(id);
    }

    @PutMapping(value = "/getAllGreetingMessages")
    public List<GreetingEntity> getAllGreetings() {
        return greetingService.greetings();
    }

    @PutMapping(value = "/editGreetingMessage/{id}")
    public GreetingEntity editAllMessage(@PathVariable int id, @RequestBody GreetingDTO greetingDto) {
        return greetingService.editGreetingMessage(id,greetingDto);
    }

    @DeleteMapping(value = "/deleteGreetingMessae")
    public String delete(@RequestParam int id) {
        return greetingService.deleteGreeting(id);
    }
}













