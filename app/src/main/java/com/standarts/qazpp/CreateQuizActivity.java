package com.standarts.qazpp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateQuizActivity extends AppCompatActivity {
    EditText quizName, quizQuestions;
    QuestionInputParser parser = new QuestionInputParser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);

        quizName = findViewById(R.id.nameTextEdit);
        quizQuestions = findViewById(R.id.questionsTextEdit);
    }

    public void createClick(View view) {
        String name = quizName.getText().toString();
        String questions = quizQuestions.getText().toString();
        if(name.equals("") || questions.equals("")){
            Toast.makeText(this, "You must fill both text fields to proceed", Toast.LENGTH_SHORT).show();
            return;
        }
        Quiz quiz = new Quiz(name, "Anonymous", parser.ParseQuestions(questions));
        if(quiz.Questions().isEmpty()){
            Toast.makeText(this,"Questions were not typed in right format, check examples", Toast.LENGTH_LONG).show();
            return;
        }
        String json = quiz.ToJson();
        Log.d("GENERIC", json);
        /*if(quiz.Size() < 2){
            Toast.makeText(this,"Questions must have at least 2 answers, otherwise what's the point?", Toast.LENGTH_LONG).show();
            return;
        }*/
        String filename = name.trim().toLowerCase().replace(" ", "_");
        Log.d("FILES", filename);
        if(FileHelper.WriteToFile(filename, json)){
            Toast.makeText(this, "Quiz written to new file " + filename + ".json", Toast.LENGTH_SHORT).show();
        }
    }
}