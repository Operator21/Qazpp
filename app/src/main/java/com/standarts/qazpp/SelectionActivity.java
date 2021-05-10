package com.standarts.qazpp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        Context context = this;

        Intent in = getIntent();
        if(in.hasExtra("edit")){
            ((Button)findViewById(R.id.resetFilesButton)).setVisibility(View.INVISIBLE);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                if(in.hasExtra("edit")){
                    i = new Intent(context, CreateQuizActivity.class);
                } else {
                    i = new Intent(context, QuizActivity.class);
                }

                i.setFlags(i.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                i.putExtra("quiz", new Gson().toJson(parent.getAdapter().getItem(position)));
                startActivity(i);
            }
        });
        listView.setAdapter(new FileListAdapter(this, quizList));
    }

    public void resetClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Restoring defaults");
        builder.setMessage("By continuing you will reset all application files, your changes will be deleted and default quizzes will be created again. This operation cannot be taken back!");

        Context context = this;
        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DefaultFilesCreator.CreateDefaultFiles();
                Toast.makeText(context, "Files have been restored to default.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context, MenuActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }
}