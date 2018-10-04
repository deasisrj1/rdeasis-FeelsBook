package com.example.rdeasis_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Comment extends AppCompatActivity {


    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        // Inflates the ListView of Comment Activity with the list of comments in a selected emotion
        Bundle extras = getIntent().getExtras();
        final ArrayList<String> comments = extras.getStringArrayList("comments");
        this.position = extras.getInt("position");


        final ListView listView = (ListView) findViewById(R.id.commentListView);
        final CommentListAdapter adapter = new CommentListAdapter(this, R.layout.adapter_comment_layout, comments);

        listView.setAdapter(adapter);


    }

    // Add a comment in the list comments of a selected Emotion
    public void addComment(View view) {

        ArrayList<Emotion> emotionsList = EmotionListController.getEmotionList().getEmotions();
        Emotion emotion = emotionsList.get(position);

        EditText getComment = (EditText) findViewById(R.id.commentWriter);
        String comment = getComment.getText().toString();

        emotion.addComment(comment);
        finish();









    }



}
