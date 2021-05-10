package com.standarts.qazpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    //SoundHelper soundHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ArrayList<File> files = FileHelper.GetStorageFilesOfType("json");
        for(File file : files){
            Log.d("FILES", FileHelper.FileNameOnly(file));
        }
        //soundHelper = new SoundHelper(this);
    }

    public void PlayClick(View view) {
        //Intent i = new Intent(this, QuizActivity.class);
        Intent i = new Intent(this, SelectionActivity.class);
        startActivity(i);
    }

    public void createClick(View view) {
        Intent i = new Intent(this, CreateQuizActivity.class);
        startActivity(i);
    }

    private void startActivityForResult(Intent i) {
        String file = i.getStringExtra("file");
        Log.d("FILES", file);
    }

    public void editClick(View view) {
        //soundHelper.PlayClick();
        Intent i = new Intent(this, SelectionActivity.class);
        i.putExtra("edit", true);
        startActivity(i);
        //finish();
    }
}