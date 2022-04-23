package com.example.greetingapp1.repository;


import com.example.greetingapp1.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GreetingAppRepository extends JpaRepository<Greeting, Integer> {

};
