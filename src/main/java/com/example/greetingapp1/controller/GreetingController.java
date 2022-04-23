package com.example.greetingapp1.controller;



import com.example.greetingapp1.Service.GreetingService;
import com.example.greetingapp1.model.Greeting;
import com.example.greetingapp1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@RestController
public class GreetingController {
    private static final String template="Hello %s";
    private static AtomicInteger counter=new AtomicInteger();

    @Autowired
    GreetingService greetingService;

    @GetMapping("/getGreeting")
    public Greeting greeting(@RequestParam (value="name",defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }
    @PostMapping("/postGreeting")
    public Greeting sayHello(@RequestBody Greeting greeting) {
        return new Greeting(counter.incrementAndGet(),String.format(template, greeting.getContent()));
    }
    @PutMapping("/putMapping/{counter}")
    public Greeting sayHello(@PathVariable Integer counter,@RequestParam (value="content") String content) {
        return new Greeting(counter,String.format(template, content));
    }
    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage(){
        return new ResponseEntity<String>(greetingService.getMessage(),HttpStatus.OK);
    }
    @GetMapping("/getGreetingMessage")
    public ResponseEntity<String>getGreetingMessage(@RequestParam(value="fName",defaultValue="World") String fName,@RequestParam(value="lName",defaultValue="") String lName){
        return new ResponseEntity<String>(greetingService.getGreetingMessage(fName,lName),HttpStatus.OK);
    }
    @PostMapping("/postMessage")
    public ResponseEntity<String> getGreeting(@RequestBody User user){
        return new ResponseEntity<String>(greetingService.postMessage(user),HttpStatus.OK);
    }
    @PostMapping("/saveGreeting")
    public ResponseEntity<Greeting> saveGreeting(@RequestBody Greeting greeting){
        return new ResponseEntity<Greeting>(greetingService.saveMessage(greeting),HttpStatus.OK);
    }
    @GetMapping("/findGreetingById")
    public ResponseEntity<String> findGreetingById(@RequestParam Integer id){
        return new ResponseEntity<String>(greetingService.getDataById(id),HttpStatus.OK);
    }
    @GetMapping("/findAllGreeting")
    public ResponseEntity<List<Greeting>> findAllGreeting(){
        return new ResponseEntity<List<Greeting>>(greetingService.getAllData(),HttpStatus.OK);
    }
    @PutMapping("/editGreetingById/{id}")
    public ResponseEntity<Greeting> editGreeting(@RequestParam String content,@PathVariable Integer id){
        return new ResponseEntity<Greeting>(greetingService.editData(id,content),HttpStatus.OK);
    }
}
