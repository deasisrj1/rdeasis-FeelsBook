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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String FILENAME = "file.sav";
    private ArrayList<Emotion> emotions ;

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
                //Log.d("BUTTON", "love button");
                emotionName = "Love";
                break;
            case R.id.joyButton:
              //  Log.d("BUTTON", "joy button");
                emotionName = "Joy";
                break;
            case R.id.surpriseButton:
              //  Log.d("BUTTON", "surprise button");
                emotionName = "Surprise";
                break;
            case R.id.angerButton:
               // Log.d("BUTTON", "anger button");
                emotionName = "Anger";
                break;
            case R.id.sadnessButton:
              //  Log.d("BUTTON", "sadness button");
                emotionName = "Sadness";
                break;
            case R.id.fearButton:
              //  Log.d("BUTTON", "love button");
                emotionName = "Fear";
                break;
        }

        if (!commentText.matches("")) {
            Toast.makeText(this, "Emotion Recorded", Toast.LENGTH_SHORT).show();
            elc.addEmotion(new Emotion(emotionName, commentText,new Date()));
            emotions = EmotionListController.getEmotionList().getEmotions();
            saveInFile();
        } else if ( commentText.matches("")) {
            Toast.makeText(this, "Emotion Recorded", Toast.LENGTH_SHORT).show();
            elc.addEmotion(new Emotion(emotionName, new Date()));
            emotions = EmotionListController.getEmotionList().getEmotions();
            saveInFile();
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        loadFromFile();

    }

    private void loadFromFile() {
        try {
            Log.d("SAVINGLOADING","im re loaded");
            FileInputStream fis = openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);

            Gson gson = new Gson();
            Type listEmotionType = new TypeToken<ArrayList<Emotion>>(){}.getType();
            emotions = gson.fromJson(reader, listEmotionType);
            EmotionListController.getEmotionList().setEmotionList(emotions);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     private void saveInFile() {
        try{
            Log.d("SAVINGLOADING","im re loading");
            FileOutputStream fos = openFileOutput(FILENAME, 0);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter writer = new BufferedWriter(osw);
            Gson gson = new Gson();
            gson.toJson(emotions, writer);
            writer.flush();
            fos.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }



}
