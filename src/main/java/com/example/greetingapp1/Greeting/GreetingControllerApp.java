package com.example.greetingapp1.Greeting;

import com.example.greetingapp1.Service.GreetingService;
import com.example.greetingapp1.model.Greeting;
import com.example.greetingapp1.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/hello")
public class GreetingControllerApp {
@Autowired
private GreetingService Service;
    private static final String template = "Hello %s";
    private static AtomicLong counter = new AtomicLong();

    @GetMapping("/getGreeting")
    public Greeting greeting(@RequestParam(value="name",defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }
    @PostMapping("/postGreeting")
    public Greeting sayHello(@RequestBody Greeting greeting) {
        return new Greeting(counter.incrementAndGet(),String.format(template, greeting.getContent()));
    }
    @PutMapping("/putMapping/{counter}")
    public Greeting sayHello(@PathVariable long counter,@RequestParam (value="content") String content) {
        return new Greeting(counter,String.format(template, content));
    }
}


