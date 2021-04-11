package com.standarts.qazpp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AnswerListAdapter extends ArrayAdapter<String> {
    private Context answerContext;
    private List<String> answersList = new ArrayList<>();

    public AnswerListAdapter(@NonNull Context context, ArrayList<String> list){
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

        String currentAnswer = answersList.get(position);
        ((TextView)listItem.findViewById(R.id.answerText)).setText(currentAnswer);


        return listItem;
    }
    public String getItem(int position){
        return answersList.get(position);
    }
}
