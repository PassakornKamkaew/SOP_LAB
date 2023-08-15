package com.example.lab1;

public class Customer {
    private String ID;
    private String name;
    private boolean sex;
    private int age;

    public Customer(){
        this("", null, "female", 0);
    }

    public Customer(String ID, String name, String sex, int age){
        if (sex.equals("male") || sex.equals("Male")) {
            this.sex = true;
        }
        else {
            this.sex = false;
        }
        this.ID = ID;
        this.name = name;
        this.age = age;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    public String getID(){
        return ID;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSex(boolean sex){
        this.sex = sex;
    }

    public boolean getSex(){
        return sex;
    }

    public void setAge(int age){
        if (age < 0){
            this.age = 0;
        }
        else {
            this.age = age;
        }
    }

    public int getAge(){
            return age;
    }
}
