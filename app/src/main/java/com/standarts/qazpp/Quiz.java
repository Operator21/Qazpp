package com.standarts.qazpp;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Quiz {
    private String name;
    private String author;
    private ArrayList<Question> questions = new ArrayList<>();

    public Quiz(String name, String author, ArrayList<Question> questions){
        this.name = name;
        this.author = author;
        for (Question question : questions) {
            this.questions.add(question);
        }
    }
    public Quiz(String name, String author){
        this.name = name;
        this.author = author;
    }

    public void Add(Question question){
        questions.add(question);
    }

    public String Name(){
        return name;
    }

    public ArrayList<Question> Question(){
        return questions;
    }

    public String ToJson(){
        return new Gson().toJson(this);
    }
}
