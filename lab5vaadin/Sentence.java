package com.example.lab5vaadin;

import java.io.Serializable;
import java.util.ArrayList;

public class Sentence  implements Serializable {
    public ArrayList<String> badSentences = new ArrayList<String>();
    public ArrayList<String> goodSentences = new ArrayList<String>();

    public void setGoodSentences(ArrayList<String> goodSentences) {
        this.goodSentences = goodSentences;
    }

    public ArrayList<String> getGoodSentences() {
        return goodSentences;
    }

    public void setBadSentences(ArrayList<String> badSentences) {
        this.badSentences = badSentences;
    }

    public ArrayList<String> getBadSentences() {
        return badSentences;
    }
}

