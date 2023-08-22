package com.example.demo1;

import org.springframework.web.bind.annotation.*;

@RestController
public class MathAPI {
    @RequestMapping(value = "/plus/{n1}/{n2}", method = RequestMethod.GET)
    public float myPlus(@PathVariable("n1") float n1, @PathVariable("n2") float n2){
        return n1 + n2;
    }

    @RequestMapping(value = "/minus/{n1}/{n2}", method = RequestMethod.GET)
    public float myMinus(@PathVariable("n1") float n1, @PathVariable("n2") float n2){
        return n1 - n2;
    }

    @RequestMapping(value = "/divide/{n1}/{n2}", method = RequestMethod.GET)
    public float myDivide(@PathVariable("n1") float n1, @PathVariable("n2") float n2){
        return n1 / n2;
    }

    @RequestMapping(value = "/multi/{n1}/{n2}", method = RequestMethod.GET)
    public float myMulti(@PathVariable("n1") float n1, @PathVariable("n2") float n2){
        return n1 * n2;
    }

    @RequestMapping(value = "/mod/{n1}/{n2}", method = RequestMethod.GET)
    public float myMod(@PathVariable("n1") float n1, @PathVariable("n2") float n2){
        return n1 % n2;
    }

    @RequestMapping(value = "/max", method = RequestMethod.POST)
    public float myMax(@RequestParam("nn1") float n1, @RequestParam("nn2") float n2){
        if (n1 > n2){
            return n1;
        }
        else {
            return n2;
        }
    }
}
