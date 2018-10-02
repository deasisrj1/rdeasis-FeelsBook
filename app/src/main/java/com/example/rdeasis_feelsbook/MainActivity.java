package com.example.rdeasis_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id) {
            case R.id.count:
                Toast.makeText(this, "count", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Count.class);
                startActivity(intent);
                break;

            case R.id.history:
                Toast.makeText(this, "history", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(MainActivity.this, History.class);
                startActivity(intent1);
                break;
        }

        return true;

    }

    public void recordFeeling(View v) {
        String emotionName = "";
        EmotionListController elc = new EmotionListController();
        EditText textView = findViewById(R.id.addComment);
        String commentText = textView.getText().toString();

        switch(v.getId()){
            case R.id.loveButton:
                Log.d("BUTTON", "love button");
                emotionName = "Love";
                break;
            case R.id.joyButton:
                Log.d("BUTTON", "joy button");
                emotionName = "Joy";
                break;
            case R.id.surpriseButton:
                Log.d("BUTTON", "surprise button");
                emotionName = "Surprise";
                break;
            case R.id.angerButton:
                Log.d("BUTTON", "anger button");
                emotionName = "Anger";
                break;
            case R.id.sadnessButton:
                Log.d("BUTTON", "sadness button");
                emotionName = "Sadness";
                break;
            case R.id.fearButton:
                Log.d("BUTTON", "love button");
                emotionName = "Fear";
                break;
        }

        if (!commentText.matches("")) {
            elc.addEmotion(new Emotion(emotionName, commentText));
        } else if ( commentText.matches("")) {
            elc.addEmotion(new Emotion(emotionName));
        }


    }

}
