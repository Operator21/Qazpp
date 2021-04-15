package com.standarts.qazpp;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;

public class Question {
    private String text;
    private String correctAnswer;
    private ArrayList<String> answers = new ArrayList<>();

    public Question(){}

    public Question(String text, String[] answers){
        this.text = text;
        if(answers.length > 1){
            correctAnswer = answers[0];
            for (String answer : answers) {
                this.answers.add(answer);
            }
        }
    }

    public String Text(){
        return text;
    }

    public String CorrectAnswer(){
        return correctAnswer;
    }

    public ArrayList Answers(){
        Collections.shuffle(answers);
        return answers;
    }

}
