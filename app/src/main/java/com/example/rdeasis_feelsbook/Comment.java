package com.example.rdeasis_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class Comment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        Bundle extras = getIntent().getExtras();
        ArrayList<String> comments = extras.getStringArrayList("comments");

        for(String comment:comments) {
            Log.d("comments", comment);
        }
    }
}
