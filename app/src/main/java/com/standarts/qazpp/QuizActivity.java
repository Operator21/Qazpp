package com.standarts.qazpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    ArrayList<Question> questions;
    int currentPosition = 0;
    int score = 0;
    Question currentQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        /*questions = new ArrayList<>();
        questions.add(new Question("What is female Shepard's default name?", new String[]{"Jane", "Sarah", "Lucy", "Lara", "Lindsey"}));
        questions.add(new Question("Who created the Genophage?", new String[]{"Salarians", "Turians", "Krogans", "Rachni", "Drell"}));
        questions.add(new Question("Who created the Geth?", new String[]{"Quarians", "Turians", "Asari", "Humans", "Reapers"}));
        questions.add(new Question("What is Samara's daughter Morinth?", new String[]{"Ardat Yakshi", "Spectre", "Justicar"}));
        questions.add(new Question("What was the name of the Prothean V.I on Ilos?", new String[]{"Vigil", "Glyph","EDI"}));
        questions.add(new Question("Male Shepard and Garrus have the same voice actor.", new String[]{"Yes", "No"}));*/
        //LoadQuestion(questions.get(currentPosition));
        Gson gson = new Gson();
        //Toast.makeText(this, "No more questions. Carry on", Toast.LENGTH_LONG).show();
        /*if(!FileHelper.WriteToFile("masseffect", gson.toJson(questions, new TypeToken<ArrayList<Question>>() {}.getType()))){
            Toast.makeText(this, "Error occurred", Toast.LENGTH_LONG).show();
        }*/

        String json = FileHelper.ReadFromFile("masseffect");
        Toast.makeText(this, json, Toast.LENGTH_LONG).show();
        Log.d("JSON", json);

        ArrayList<Question> questionsFromFile = gson.fromJson(FileHelper.ReadFromFile("test"), new TypeToken<ArrayList<Question>>() {}.getType());
        /*for (Question q: questionsFromFile) {
            Toast.makeText(this, q.Text(), Toast.LENGTH_SHORT).show();
        }*/
        //LoadQuestion(questionsFromFile.get(0));
    }

    void LoadQuestion(Question question){
        currentQuestion = question;
        ((TextView)findViewById(R.id.questionText)).setText(question.Text());

        AnswerListAdapter adapter = new AnswerListAdapter(this, question.Answers());
        ((ListView)findViewById(R.id.answerList)).setAdapter(adapter);
        ((ListView)findViewById(R.id.answerList)).setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String answer = adapter.getItem(position);
                if(answer.equals(question.CorrectAnswer())){
                    score++;
                }
                NextQuestion();
            }
        });
    }
    void NextQuestion(){
        if(currentPosition < questions.size()-1){
            currentPosition++;
            LoadQuestion(questions.get(currentPosition));
        } else {
            //Toast.makeText(this, "No more questions. Carry on", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, FinalScoreActivity.class);
            i.putExtra("score", score);
            i.putExtra("maxscore", questions.size());

            startActivity(i);
        }
    }
}