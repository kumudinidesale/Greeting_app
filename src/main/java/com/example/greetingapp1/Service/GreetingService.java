package com.example.greetingapp1.Service;

import com.example.greetingapp1.model.Greeting;
import com.example.greetingapp1.model.User;
import com.example.greetingapp1.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {
    private static String template="Hello %s";

    @Autowired
    GreetingAppRepository repo;

    public String getMessage() {
        return "Hello World";
    }
    public String getGreetingMessage(String fName, String lName) {
        return "Hello "+fName+""+lName;
    }
    public String postMessage(User user) {
        return "Hello "+user.getfName()+""+user.getlName();
    }
    public Greeting saveMessage(Greeting greeting) {
        Greeting newGreeting=new Greeting(String.format(template,greeting.getContent()));
        repo.save(newGreeting);
        return newGreeting;
    }
    public String getDataById(Integer id) {
        Greeting newGreeting=repo.getById(id);
        return newGreeting.getContent();
    }
    public List<Greeting> getAllData() {
        List<Greeting>list=repo.findAll();
        return list;
    }
    public Greeting editData(Integer id,String content) {
        Greeting newGreeting= new Greeting(id,String.format(template,content));
        repo.save(newGreeting);
        return newGreeting;
    }
}



