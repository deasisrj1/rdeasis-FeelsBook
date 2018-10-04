package com.example.rdeasis_feelsbook;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class EmotionListAdapter extends ArrayAdapter<Emotion> {

    ArrayList<Emotion> mObjects;
    private Context mContext;
    int mResource;

    public EmotionListAdapter(Context context, int resource, ArrayList<Emotion> objects) {
        super(context, resource, objects);
        mObjects = objects;
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        String emotionName = getItem(position).getEmotionName();
        Date emotionDate = getItem(position).getDate();


        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvEmotion = (TextView) convertView.findViewById(R.id.emotionName);
        TextView tvEmotionDate = (TextView) convertView.findViewById(R.id.emotionDate);

        tvEmotion.setText(emotionName );


        TimeZone tz = TimeZone.getTimeZone("Canada/Mountain");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        df.setTimeZone(tz);

        tvEmotionDate.setText(df.format(emotionDate));

        // Listener for comment button passes along an array of comments and the position of the selected emotion
        Button commentButton = (Button) convertView.findViewById(R.id.commentButton);
        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Comment.class);
                ArrayList<String> commentsArray = getItem(position).getCommentList();
                intent.putExtra("comments", commentsArray);
                intent.putExtra("position", position);
                mContext.startActivity(intent);
            }
        });

        // Listener for Edit button passes along the position of an emotion in the list and the instance of an emotion
        Button editButton = (Button) convertView.findViewById(R.id.editButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, Edit.class);
                Emotion emotion = mObjects.get(position);

                intent.putExtra("position", position);
                intent.putExtra("emotion", emotion);
                mContext.startActivity(intent);
            }
        });

        return convertView;

    }
}
