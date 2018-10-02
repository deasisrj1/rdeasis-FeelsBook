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

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        final ListView listView = (ListView) findViewById(R.id.listView);

        final ArrayList<Emotion> emotions = EmotionListController.getEmotionList().getEmotions();

        EmotionListAdapter adapter = new EmotionListAdapter(this, R.layout.adapter_view_layout, emotions);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Printer", "printed");
                Intent intent = new Intent(view.getContext(), Count.class);
                startActivity(intent);
            }
        });


    }

}
