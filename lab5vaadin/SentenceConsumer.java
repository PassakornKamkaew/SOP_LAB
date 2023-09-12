package com.example.lab5vaadin;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class SentenceConsumer {
    public Sentence sentences = new Sentence();

    @RabbitListener(queues = "GoodWordQueue")
    public void addGoodSentence(String s){
        sentences.goodSentences.add(s);
    }

    @RabbitListener(queues = "BadWordQueue")
    public void addBadSentence(String s){
        sentences.badSentences.add(s);
    }

    @RabbitListener(queues = "GetQueue")
    public Sentence getSentences() {
        return sentences;
    }

}
