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
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    String json;
    Quiz currentQuiz;
    int currentPosition = 0;
    int score = 0;
    Question currentQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        //Quiz quiz = new Quiz("Life is Strange");

        //LoadQuestion(questions.get(currentPosition));
        Intent i = getIntent();
        if(!i.hasExtra("quiz")){
            Toast.makeText(this, "Intent quiz not sent, aborting", Toast.LENGTH_SHORT).show();
        }
        json = i.getStringExtra("quiz");
        Gson gson = new Gson();
        currentQuiz = gson.fromJson(i.getStringExtra("quiz"), Quiz.class);
        currentQuiz.ShuffleQuestions();
        currentQuestion = currentQuiz.GetQuestion(currentPosition);
        LoadQuestion(currentQuestion);
    }

    void LoadQuestion(Question question){
        currentQuestion = question;
        ((TextView)findViewById(R.id.questionText)).setText(question.Text());
        ((TextView)findViewById(R.id.pageText)).setText((currentPosition+1) + "/" + currentQuiz.Size());

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
        if(currentPosition < currentQuiz.Size()-1){
            currentPosition++;
            LoadQuestion(currentQuiz.GetQuestion(currentPosition));
        } else {
            //Toast.makeText(this, "No more questions. Carry on", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, FinalScoreActivity.class);
            i.putExtra("score", score);
            i.putExtra("maxscore", currentQuiz.Size());
            i.putExtra("quiz", json);

            startActivity(i);
        }
    }

    public void menuClick(View view) {
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }
}