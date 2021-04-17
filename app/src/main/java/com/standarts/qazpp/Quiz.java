package com.standarts.qazpp;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;

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
    public Question GetQuestion(int position){
        if(position < questions.size())
            return questions.get(position);
        return null;
    }

    public String Name(){
        return name;
    }
    public int Size(){
        return questions.size();
    }

    public ArrayList<Question> Questions(){
        return questions;
    }

    public String ToJson(){
        return new Gson().toJson(this);
    }
    public void ShuffleQuestions(){
        Collections.shuffle(questions);
    }
}
