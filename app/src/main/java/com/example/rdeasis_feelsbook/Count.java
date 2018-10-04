package com.example.rdeasis_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Count extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        EmotionListController elc = new EmotionListController();
        int loveCount = elc.getOccurrence("Love");
        int joyCount = elc.getOccurrence("Joy");
        int surpriseCount = elc.getOccurrence("Surprise");
        int angerCount = elc.getOccurrence("Anger");
        int sadnessCount = elc.getOccurrence("Sadness");
        int fearCount = elc.getOccurrence("Fear");

        // Sets the TextViews of count with the number of each Emotion that are recorded
        TextView countLove = (TextView) findViewById(R.id.countLove);
        countLove.setText("Love: " + loveCount);

        TextView countJoy = (TextView) findViewById(R.id.countJoy);
        countJoy.setText("Joy: " + joyCount);

        TextView countSurprise = (TextView) findViewById(R.id.countSurprise);
        countSurprise.setText("Surprise: " + surpriseCount);

        TextView countAnger = (TextView) findViewById(R.id.countAnger);
        countAnger.setText("Anger: " + angerCount);

        TextView countSadness = (TextView) findViewById(R.id.countSadness);
        countSadness.setText("Sadness: " + sadnessCount);

        TextView countFear = (TextView) findViewById(R.id.countFear);
        countFear.setText("Fear: " + fearCount);



    }
}
