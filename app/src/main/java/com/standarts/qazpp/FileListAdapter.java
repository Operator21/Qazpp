package com.standarts.qazpp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FileListAdapter extends ArrayAdapter<Quiz> {
    private Context answerContext;
    private List<Quiz> answersList = new ArrayList<>();

    public FileListAdapter(@NonNull Context context, ArrayList<Quiz> list){
        super(context, 0, list);
        answerContext = context;
        answersList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View listItem = convertView;
        if(listItem == null){
            listItem = LayoutInflater.from(answerContext).inflate(R.layout.answerlayout, parent, false);
        }

        Quiz currentquiz = answersList.get(position);
        ((TextView)listItem.findViewById(R.id.answerText)).setText(currentquiz.Name());


        return listItem;
    }
    public Quiz getItem(int position){
        return answersList.get(position);
    }
}
