package com.standarts.qazpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class FinalScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        Intent data = getIntent();
        if(!data.hasExtra("score") && !data.hasExtra("maxscore")){
            Toast.makeText(this, "Unexpected error occured", Toast.LENGTH_LONG);
            return;
        }

        ((TextView)findViewById(R.id.finalscoreText)).setText(String.format("%d %s %d", data.getIntExtra("score", 0), getResources().getString(R.string.outof), data.getIntExtra("maxscore", 0)));
    }
}