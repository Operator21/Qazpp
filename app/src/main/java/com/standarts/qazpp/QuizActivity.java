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
    ArrayList<Question> questions = new ArrayList<>();
    int currentPosition = 0;
    int score = 0;
    Question currentQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        //Quiz quiz = new Quiz("Life is Strange");

        //LoadQuestion(questions.get(currentPosition));

        Gson gson = new Gson();
        //FileHelper.WriteToFile("sg", gson.toJson(questions));

        //masseffect | lis | sg
        String json = FileHelper.ReadFromFile("sg");
        Log.d("JSON", json);

        if(json.isEmpty()){
            Toast.makeText(this, "File does not exist", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, MenuActivity.class);
            startActivity(i);
            return;
        }
        for (Question question : (ArrayList<Question>)gson.fromJson(json, new TypeToken<ArrayList<Question>>() {}.getType())) {
            questions.add(question);
        }
        Collections.shuffle(questions);
        LoadQuestion(questions.get(0));
    }

    void LoadQuestion(Question question){
        currentQuestion = question;
        ((TextView)findViewById(R.id.questionText)).setText(question.Text());
        ((TextView)findViewById(R.id.pageText)).setText((currentPosition+1) + "/" + questions.size());

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

    public void menuClick(View view) {
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }
}