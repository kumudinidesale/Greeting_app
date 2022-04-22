package com.example.greetingapp1.Greeting;

import com.example.greetingapp1.model.User;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/hello")
public class GreetingControllerApp {

    private static final String template = "Hello %s";
    private static AtomicLong counter = new AtomicLong();

    @RequestMapping(value = {"","/","/home"})
    public String sayHello(){
        return "Hello from Bridgelabz!!!";
    }


    @RequestMapping(value = {"/query"},method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name") String name){
        return "Hello "+name+"!";
    }


    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name){
        return "Hello " +name+"!";
    }

    @PostMapping("/post")
    public  String sayHello(@RequestBody User user){
        return  "Hello" +user.getFirstName()+" "+user.getLastName() + "!";
    }



    @PutMapping("/put/{firstName}")
    public  String sayHello(@PathVariable String firstName,
                            @RequestParam(value = "lastName") String lastName){
        return "Hello "+ firstName+" "+lastName+ "!";
    }
}