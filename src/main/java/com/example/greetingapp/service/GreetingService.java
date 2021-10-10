package com.example.greetingapp.service;

import com.example.greetingapp.dto.GreetingDTO;
import com.example.greetingapp.entity.GreetingEntity;
import com.example.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public List<GreetingEntity> greetings() {
        return greetingRepository.findAll();
    }

    public String getGreetingMessage() {
        return "Hello World !!";
    }

    public String getGreetingWithName(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName + "!";
    }

    public GreetingEntity addGreeting(GreetingDTO greetingDTO) {
        GreetingEntity greetingEntity = new GreetingEntity();
        greetingEntity.setMessage(greetingDTO.getMessage());
        return greetingRepository.save(greetingEntity);

    }

    public GreetingEntity getMessageByID(int id) {
        Optional<GreetingEntity> greetingEntity = greetingRepository.findById(id);
        if (greetingEntity.isPresent()) {
            return greetingEntity.get();
        }
        return null;
    }


    public GreetingEntity editGreetingMessage(int id, GreetingDTO greetingDTO) {
        Optional<GreetingEntity> updateGreeting = greetingRepository.findById(id);
        if (updateGreeting.isPresent()) {
            GreetingEntity greetingEntity = updateGreeting.get();
            greetingEntity.setMessage(greetingDTO.getMessage());
        }
        return null;
    }

    public String deleteGreeting(int id) {
        Optional<GreetingEntity> deleteGreeting = greetingRepository.findById(id);
        if (deleteGreeting.isPresent()) {
            greetingRepository.delete(deleteGreeting.get());
            return "Record Deleted !!";
        }
        return "Record not Found !!";
    }

}













