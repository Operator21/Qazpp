package com.standarts.qazpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class FinalScoreActivity extends AppCompatActivity {
    String json;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        Intent data = getIntent();
        if(!data.hasExtra("score") || !data.hasExtra("maxscore") || !data.hasExtra("quiz")){
            Toast.makeText(this, "Unexpected error occured", Toast.LENGTH_LONG);
            return;
        }
        json = data.getStringExtra("quiz");
        ((TextView)findViewById(R.id.finalscoreText)).setText(String.format("%d %s %d", data.getIntExtra("score", 0), getResources().getString(R.string.outof), data.getIntExtra("maxscore", 0)));
    }

    public void restartClick(View view) {
        Intent i = new Intent(this, QuizActivity.class);
        i.putExtra("quiz", json);
        i.setFlags(i.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
        //finishAffinity();
        startActivity(i);
    }

    public void menuClick(View view) {
        Intent i = new Intent(this, MenuActivity.class);
        i.setFlags(i.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(i);
    }
}