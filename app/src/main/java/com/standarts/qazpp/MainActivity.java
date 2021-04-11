package com.standarts.qazpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Question> questions;
    int currentPosition = 0;
    int score = 0;
    Question currentQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questions = new ArrayList<>();

        questions.add(new Question("Who is Commander Shepard?", new String[]{"Alliance soldier", "Turian officer", "Salarian STG commando"}));
        questions.add(new Question("5 + 4 =", new String[]{"9","10","8","17","12","7"}));
        //LoadQuestion(questions.get(currentPosition));
        Gson gson = new Gson();
        //Toast.makeText(this, "No more questions. Carry on", Toast.LENGTH_LONG).show();
        /*if(!FileHelper.WriteToFile("test", gson.toJson(questions))){
            Toast.makeText(this, "Error occurred", Toast.LENGTH_LONG).show();
        }*/
        Toast.makeText(this, FileHelper.ReadFromFile("test"), Toast.LENGTH_LONG).show();

        //ArrayList<Question> questionsFromFile = gson.fromJson(FileHelper.ReadFromFile("test"), ArrayList.class);
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