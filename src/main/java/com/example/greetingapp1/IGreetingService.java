package com.example.greetingapp1;

import com.example.greetingapp1.model.Greeting;
import com.example.greetingapp1.model.User;

public interface IGreetingService {

    Greeting addGreeting(User user);
    Greeting getGeetingById(long id);
}
