package com.example.lab5vaadin;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class WordPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public Word words = new Word();

    @RequestMapping(value = "/addBad/{w1}", method = RequestMethod.POST)
    public ArrayList<String> addBadWord(@PathVariable("w1") String s){
        words.badWords.add(s);
        return words.badWords;
    }

    @RequestMapping(value = "/delBad/{w2}", method = RequestMethod.GET)
    public ArrayList<String> deleteBadWord(@PathVariable("w2") String s){
        words.badWords.remove(s);
        return words.badWords;
    }

    @RequestMapping(value = "/addGood/{w3}", method = RequestMethod.POST)
    public ArrayList<String> addGoodWord(@PathVariable("w3") String s){
        words.goodWords.add(s);
        return words.goodWords;
    }

    @RequestMapping(value = "/delGood/{w4}", method = RequestMethod.GET)
    public ArrayList<String> deleteGoodWord(@PathVariable("w4") String s){
        words.goodWords.remove(s);
        return  words.goodWords;
    }

    @RequestMapping(value = "/proof/{sentence}", method = RequestMethod.POST)
    public String proofSentence(@PathVariable("sentence") String s){
        boolean isGood = false;
        boolean isBad = false;
        for (String goodWord : words.goodWords) {
            if (s.contains(goodWord)) {
                isGood = true;
                break;
            }
        }
        for (String badWord : words.badWords) {
            if (s.contains(badWord)) {
                isBad = true;
                break;
            }
        }

        if(isGood && isBad){
            rabbitTemplate.convertAndSend("Fanout","",s);
            return "Found Good and Bad Sentence";
        }
        else if(isGood){
            rabbitTemplate.convertAndSend("Direct","good",s);
            return "Found Good Sentence";
        }
        else if(isBad){
            rabbitTemplate.convertAndSend("Direct","bad",s);
            return "Found Bad Sentence";
        }
        return "Not Found Good or Bad Sentence";
    }

    @RequestMapping(value = "/getWord",method = RequestMethod.GET)
    public Word getWord(){
        return words;

    }

    @RequestMapping(value = "/getSentence", method = RequestMethod.GET)
    public Sentence getSentence(){
        Object result = rabbitTemplate.convertSendAndReceive("Direct","","");
        return ((Sentence) result);
    }

}