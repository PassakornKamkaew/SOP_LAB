package com.example.lab5vaadin;

import java.util.ArrayList;

public class Word {
    public ArrayList<String> badWords = new ArrayList<String>();
    public ArrayList<String> goodWords = new ArrayList<String>();

    public Word(){
        goodWords.add("happy");
        goodWords.add("enjoy");
        goodWords.add("like");
        badWords.add("fuck");
        badWords.add("olo");
    }

    public ArrayList<String> getBadWords() {
        return badWords;
    }

    public void setBadWords(ArrayList<String> badWords) {
        this.badWords = badWords;
    }

    public ArrayList<String> getGoodWords() {
        return goodWords;
    }

    public void setGoodWords(ArrayList<String> goodWords) {
        this.goodWords = goodWords;
    }
}