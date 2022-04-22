package com.example.greetingapp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingApp1Application {

    public static void main(String[] args) {

        SpringApplication.run(GreetingApp1Application.class, args);
        System.out.print("Hello");
    }

}
