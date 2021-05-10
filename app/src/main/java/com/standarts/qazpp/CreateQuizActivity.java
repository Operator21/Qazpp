package com.standarts.qazpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class CreateQuizActivity extends AppCompatActivity {
    EditText quizName, quizQuestions;
    QuestionInputParser parser = new QuestionInputParser();
    String filename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);

        quizName = findViewById(R.id.nameTextEdit);
        quizQuestions = findViewById(R.id.questionsTextEdit);

        Intent i = getIntent();
        if(!i.hasExtra("quiz")) {
            ((Button)findViewById(R.id.deleteQuizButton)).setVisibility(View.INVISIBLE);
        } else {
            ((Button)findViewById(R.id.createQuizButton)).setText("Edit Quiz");
            Quiz quiz = new Gson().fromJson(i.getStringExtra("quiz"), Quiz.class);
            quizName.setText(quiz.Name());
            quizQuestions.setText(new QuestionInputParser().QuizQuestionsToString(quiz));
            filename = FileHelper.CreateSafeFilename(quiz.Name());
        }
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
        String filename = FileHelper.CreateSafeFilename(name);
        Log.d("FILES", filename);
        if(FileHelper.WriteToFile(filename, json)){
            Toast.makeText(this, "Quiz written to file " + filename + ".json", Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    public void deleteClick(View view) {
        if(FileHelper.RemoveFile(filename)) {
            Toast.makeText(this, filename + " has be removed", Toast.LENGTH_SHORT).show();
        }
        Intent i = new Intent(this, MenuActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //i.putExtra("edit", true);
        startActivity(i);
    }
}