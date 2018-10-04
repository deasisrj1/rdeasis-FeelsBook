package com.example.rdeasis_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        final ListView listView = (ListView) findViewById(R.id.listView);
        ArrayList<Emotion> emotions = EmotionListController.getEmotionList().getEmotions();

        // sorts emotions date in order
        Collections.sort(emotions, new Comparator<Emotion>() {
            @Override
            public int compare(Emotion o1, Emotion o2) {

                return o1.getDate().compareTo(o2.getDate());
            }
        });

        // inflates the ListView of history
        final EmotionListAdapter adapter = new EmotionListAdapter(this, R.layout.adapter_view_layout, emotions);
        listView.setAdapter(adapter);



        listView.invalidateViews();

        adapter.notifyDataSetChanged();


    }

}
