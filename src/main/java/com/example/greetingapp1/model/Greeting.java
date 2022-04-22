package com.example.greetingapp1.model;

public class Greeting {
    private final long id;
    private String message;

    public Greeting(){
        id = 0;
        message = "";
    }
    public Greeting(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}

