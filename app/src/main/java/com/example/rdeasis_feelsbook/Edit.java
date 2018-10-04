package com.example.rdeasis_feelsbook;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Edit extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // Displays the Emotions Date in Edit Activity
        Bundle extras = getIntent().getExtras();
        int position = extras.getInt("position");
        EmotionListController elc = new EmotionListController();
        TextView textView = (TextView) findViewById(R.id.emotionsDate);
        textView.setText(elc.getTime(position).toString());

        // Listener for Set Time Button
        Button button = (Button) findViewById(R.id.buttonSetTime);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });
    }

    // Sets the new Time of Recorded Emotion
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Bundle extras = getIntent().getExtras();
        Emotion emotion = (Emotion) extras.getSerializable("emotion");
        int position = extras.getInt("position");

        EmotionListController elc = new EmotionListController();
        elc.setTime(hourOfDay,minute,position);


        TextView textView = (TextView) findViewById(R.id.emotionsDate);
        textView.setText(elc.getTime(position).toString());

    }

    // Deletes the selected emotion from a list
    public void deleteEmotion(View view) {
        // Toast.makeText(this, "DELETED", Toast.LENGTH_SHORT).show();
        Bundle extras = getIntent().getExtras();
        int position = extras.getInt("position");
        Emotion emotion = (Emotion) extras.getSerializable("emotion");

        EmotionListController elc = new EmotionListController();
        elc.deleteEmotion(emotion, position);

        Intent intent = new Intent(this, History.class);
        startActivity(intent);

    }

}

