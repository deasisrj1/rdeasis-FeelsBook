package com.example.rdeasis_feelsbook;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class EmotionListAdapter extends ArrayAdapter<Emotion> {

    private Context mContext;
    int mResource;

    public EmotionListAdapter(Context context, int resource, ArrayList<Emotion> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        String emotionName = getItem(position).getEmotionName();
        Date emotionDate = getItem(position).getDate();

        //Emotion emotion = new Emotion(emotionName);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvEmotion = (TextView) convertView.findViewById(R.id.emotionName);
        TextView tvEmotionDate = (TextView) convertView.findViewById(R.id.emotionDate);

        tvEmotion.setText(emotionName);
        tvEmotionDate.setText(emotionDate.toString());

        Button commentButton = (Button) convertView.findViewById(R.id.commentButton);
        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Comment.class);
                ArrayList<String> commentsArray = getItem(position).getCommentList();
                intent.putExtra("comments", commentsArray);
                mContext.startActivity(intent);
            }
        });

        return convertView;
/*
       ViewHolder holder;
       View rowView = convertView;

       if(rowView == null){
           LayoutInflater inflater = LayoutInflater.from(mContext);
           rowView = inflater.inflate(mResource, parent, true);
           holder = new ViewHolder();

           holder.emotionName = (TextView) rowView.findViewById(R.id.emotionName);
           holder.emotionDate = (TextView) rowView.findViewById(R.id.emotionDate);
           holder.commentButton = (Button) rowView.findViewById(R.id.commentButton);
           holder.editButton = (Button) rowView.findViewById(R.id.editButton);
           holder.commentButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(mContext, Count.class);
                   mContext.startActivity(intent);

               }
           });
           rowView.setTag(holder);
       } else{
           holder = (ViewHolder) rowView.getTag();

       }
       holder.emotionName.setText(emotionName);
       holder.emotionDate.setText(emotionDate.toString());

       return rowView;*/
    }

    /*private class ViewHolder {
        TextView emotionName;
        TextView emotionDate;
        Button commentButton;
        Button editButton;
    }*/
}
