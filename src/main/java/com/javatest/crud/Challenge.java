package com.javatest.crud;

import lombok.Data;

@Data
public class Challenge {
    private int id;
    private int age;
    private String month;
    private String description;


    Challenge(int id, int age, String month, String description){
        this.id = id;
        this.age = age;
        this.month = month;
        this.description = description;
    }

    Challenge(){};

    public int getAge(int age) {
        return age;
    }
}
