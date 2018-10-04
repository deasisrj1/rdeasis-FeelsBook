package com.example.rdeasis_feelsbook;

import android.content.Context;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.TextView;



import java.util.ArrayList;



public class CommentListAdapter extends ArrayAdapter<String> {

    ArrayList<String> mObjects;
    private Context mContext;
    int mResource;

    public CommentListAdapter(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);
        mObjects = objects;
        mContext = context;
        mResource = resource;
    }

    // Populates the TextView with the comments of the selected Emotion
    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (!mObjects.isEmpty()) {
            String emotionName = getItem(position);

            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);

            TextView comment = (TextView) convertView.findViewById(R.id.textView2);

            comment.setText(emotionName);



        }
            return convertView;
    }
}
