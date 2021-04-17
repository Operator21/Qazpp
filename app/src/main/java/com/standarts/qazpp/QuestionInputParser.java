package com.standarts.qazpp;

import android.util.Log;

import java.util.ArrayList;

public class QuestionInputParser {
    //Question1:Correct Answer,Wrong Answer
    public QuestionInputParser(){

    }
    private Question ParseQuestion(String text){
        if(!text.contains(":")){
            return null;
        }
        String[] parts = text.split(":");
        String questionText = parts[0];
        if(parts.length < 2){
            return null;
        }
        Log.d("GENERIC",parts[1]);
        String[] answers;
        if(!parts[1].contains(",")){
            return null;
        }
        answers = parts[1].split(",");

        return new Question(questionText, answers);
    }

    public ArrayList<Question> ParseQuestions(String input){
        ArrayList<Question> questions = new ArrayList<>();
        for(String question : input.split("\n")){
            questions.add(ParseQuestion(question));
        }
        return questions;
    }
}
