package com.javatest.crud;

import jakarta.persistence.*;


@Entity
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private int age;
    @Column(name = "ChallengeMonth")
    private String month;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    Challenge(Long id, int age, String month, String description){
        this.id = id;
        this.age = age;
        this.month = month;
        this.description = description;
    }

    Challenge(){};

//    public int getAge(int age) {
//        return age;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public String getMonth() {
//        return month;
//    }
}
