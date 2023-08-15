package com.example.lab1;

import org.springframework.web.bind.annotation.*;

@RestController
public class MathService {
    @RequestMapping(value = "/add/{number1}/{number2}", method = RequestMethod.GET)
    public String add(@PathVariable("number1") double number1, @PathVariable("number2") double number2) {
        return Double.toString(number1 + number2);
    }

    @RequestMapping(value = "/minus/{number1}/{number2}", method = RequestMethod.GET)
    public String minus(@PathVariable("number1") double number1, @PathVariable("number2") double number2){
        return Double.toString(number1 - number2);
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.GET)
    public String multiply(@RequestParam("number1") double number1, @RequestParam("number2") double number2){
        return Double.toString(number1 * number2);
    }

    @RequestMapping(value = "/divide", method = RequestMethod.GET)
    public String divide(@RequestParam("number1") double number1, @RequestParam("number2") double number2){
        return Double.toString(number1 / number2);
    }
}
