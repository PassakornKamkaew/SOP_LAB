package com.example.demo1;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.button.Button;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.awt.*;

@Route(value = "index1")
public class MathView extends VerticalLayout {

    public MathView(){
        TextField txt1 = new TextField();
        txt1.setLabel("Number1");
        TextField txt2 = new TextField();
        txt2.setLabel("Number2");

        HorizontalLayout horizon = new HorizontalLayout();

        Button btn1 = new Button("+");
        Button btn2 = new Button("-");
        Button btn3 = new Button("x");
        Button btn4 = new Button("/");
        Button btn5 = new Button("Mod");
        Button btn6 = new Button("Max");

        TextField txt3 = new TextField();
        txt3.setLabel("Answer");

        horizon.add(btn1,btn2,btn3, btn4, btn5, btn6);
        this.add(txt1, txt2, horizon, txt3);

        btn1.addClickListener(event ->{
           float n1 = Float.parseFloat(txt1.getValue());
           float n2 = Float.parseFloat(txt2.getValue());

           String out = WebClient.create()
                   .get()
                   .uri("http://127.0.0.1:8080/plus/"+n1+"/"+n2)
                   .retrieve()
                   .bodyToMono(String.class)
                   .block();
                    txt3.setValue(out);
        });

        btn2.addClickListener(event ->{
            float n1 = Float.parseFloat(txt1.getValue());
            float n2 = Float.parseFloat(txt2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://127.0.0.1:8080/minus/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            txt3.setValue(out);
        });

        btn3.addClickListener(event ->{
            float n1 = Float.parseFloat(txt1.getValue());
            float n2 = Float.parseFloat(txt2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://127.0.0.1:8080/multi/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            txt3.setValue(out);
        });

        btn4.addClickListener(event ->{
            float n1 = Float.parseFloat(txt1.getValue());
            float n2 = Float.parseFloat(txt2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://127.0.0.1:8080/divide/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            txt3.setValue(out);
        });

        btn5.addClickListener(event ->{
            float n1 = Float.parseFloat(txt1.getValue());
            float n2 = Float.parseFloat(txt2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://127.0.0.1:8080/mod/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            txt3.setValue(out);
        });

        btn6.addClickListener(event ->{
            MultiValueMap<String, String> formData= new LinkedMultiValueMap<>();
            formData.add("nn1", txt1.getValue());
            formData.add("nn2", txt2.getValue());

            String out = WebClient.create()
                    .post()
                    .uri("http://127.0.0.1:8080/max")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            txt3.setValue(out);
        });
    }
}
