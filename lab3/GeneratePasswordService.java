package com.example.lab1;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class GeneratePasswordService {

    @RequestMapping(value = "{name:[A-Za-z]+}.generate", method = RequestMethod.GET)
    public String generate(@PathVariable("name") String name) {
        Random x = new Random();
        return "Hi, " + name +  "\nYour new password is " + x.nextInt(1000000) + ".";
    }
}
