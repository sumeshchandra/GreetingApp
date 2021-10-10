package com.example.greetingapp.repository;

import com.example.greetingapp.entity.GreetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingEntity, Integer> {

}
