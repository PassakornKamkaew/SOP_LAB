package com.example.lab5vaadin;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;

@Route("index2")
public class MyView2 extends HorizontalLayout {

    public MyView2(){

        FormLayout form1 = new FormLayout();
        form1.setResponsiveSteps(new FormLayout.ResponsiveStep("720px", 1));
        TextField txt1 = new TextField();
        txt1.setLabel("Add Word");
        Button btn1 = new Button("Add Good Word");
        Button btn2 = new Button("Add Bad Word");
        ComboBox<String> cbb1 = new ComboBox<>();
        cbb1.setLabel("Good Word");
        ComboBox<String> cbb2 = new ComboBox<>();
        cbb2.setLabel("Bad Word");

        FormLayout form2 = new FormLayout();
        form2.setResponsiveSteps(new FormLayout.ResponsiveStep("720px", 1));
        TextField txt2 = new TextField();
        txt2.setLabel("Add Sentence");
        Button btn3 = new Button("Add Sentence");
        TextField txt3 = new TextField();
        txt3.setLabel("Good Sentence");
        TextField txt4 = new TextField();
        txt4.setLabel("Bad Sentence");
        Button btn4 = new Button("Show Sentence");

        form1.add(txt1, btn1, btn2, cbb1, cbb2);
        form2.add(txt2, btn3, txt3, txt4, btn4);
        this.add(form1, form2);

        btn1.addClickListener(event ->{
            String wordInput = txt1.getValue();
            ArrayList<String> out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/addGood/"+wordInput)
                    .retrieve()
                    .bodyToMono(ArrayList.class)
                    .block();
            cbb1.setItems(out.toArray(new String[0]));
        });

        btn2.addClickListener(event ->{
            String wordInput = txt1.getValue();
            ArrayList<String> out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/addBad/"+wordInput)
                    .retrieve()
                    .bodyToMono(ArrayList.class)
                    .block();
            cbb2.setItems(out.toArray(new String[0]));
        });

        btn3.addClickListener(event ->{
            String senInput = txt2.getValue();
            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/proof/"+senInput)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            new Notification( out, 3000).open();

        });

        btn4.addClickListener(event ->{

            Sentence out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/getSentence")
                    .retrieve()
                    .bodyToMono(Sentence.class)
                    .block();
            txt3.setValue(out.goodSentences.toString());
            txt4.setValue(out.badSentences.toString());


        });
        Word out = WebClient.create()
                .get()
                .uri("http://localhost:8080/getWord")
                .retrieve()
                .bodyToMono(Word.class)
                .block();
        cbb1.setItems(out.goodWords.toArray(new String[0]));
        cbb2.setItems(out.badWords.toArray(new String[0]));
    }
}
