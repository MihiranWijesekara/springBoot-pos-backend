package com.example.demo.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test")
@CrossOrigin

public class TestController {


    @GetMapping(path = "/get-my-text")
    public void getMyText(){
        String myText = "Hello, this is a test message!";
        System.out.println(myText);
    }

    @GetMapping(path = "/get-my-text-01")
    public String getMyText01(){
        String myText = "Hello, this is a test message!";
        return myText;
    }

}

