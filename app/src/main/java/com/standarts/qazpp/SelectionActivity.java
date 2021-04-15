package com.standarts.qazpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        ArrayList<Quiz> quizList = new ArrayList<>();

        for(File file : FileHelper.GetStorageFilesOfType("json")){
            Log.d("FILES", file.getName());
            Quiz q = new Gson().fromJson(FileHelper.ReadFromFile(FileHelper.FileNameOnly(file)), Quiz.class);
            quizList.add(q);
        }
        if(quizList.isEmpty()){
            return;
        }
        ListView listView = findViewById(R.id.fileList);
        listView.setAdapter(new FileListAdapter(this, quizList));
    }

    public void resetClick(View view) {
        DefaultFilesCreator.CreateDefaultFiles();
        startActivity(new Intent(this, SelectionActivity.class));
    }
}