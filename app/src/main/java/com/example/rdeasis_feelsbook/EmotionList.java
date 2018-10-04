package com.example.rdeasis_feelsbook;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;

public class EmotionList {

    public ArrayList<Emotion> emotionList;
    public ArrayList<String> emotionCount;

    public EmotionList(){
        emotionList = new ArrayList<Emotion>();
        emotionCount = new ArrayList<String>();
    }

    public ArrayList<Emotion> getEmotions() {
        return emotionList;
    }

    // adds a new Emotion to list and keeps track of emotion count
    public void addEmotion(Emotion emotion) {

        emotionList.add(emotion);
        emotionCount.add(emotion.getEmotionName());
    }

    // Removes a recorded emotion from list of emotions
    public void deleteEmotion(Emotion emotion, int position) {

        Log.d("deleted", "hi " + emotionList.size());

        emotionList.remove(position);
        emotionCount.remove(emotion.getEmotionName());

        Log.d("deleted", "hi " + emotionList.size());

    }

    // returns the number of occurrences of each recorded Emotion
    public Integer getOccurrences (String emotionName) {
        int occurrences = Collections.frequency(emotionCount, emotionName);

        return occurrences;
    }

    // Sets the new time for an emotion
    public void setTime(int hour, int minute, int position) {
        emotionList.get(position).setTime(hour,minute);
    }

    public void setEmotionList(ArrayList<Emotion> emotion) {
        emotionList = emotion;
    }

}
