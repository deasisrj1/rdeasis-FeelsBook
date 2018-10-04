package com.example.rdeasis_feelsbook;

import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

public class EmotionListController  {
    private static EmotionList emotionList = null;

    static public EmotionList getEmotionList() {
        if (emotionList == null) {
            emotionList = new EmotionList();
        }
        return emotionList;
    }

    // adds an emotion to the list
    public void addEmotion(Emotion emotion){
        getEmotionList().addEmotion(emotion);
    }

    // returns an array of emotions
    public ArrayList<Emotion> getEmotion() {
        return getEmotionList().getEmotions();
    }

    // sets the time of an emotion
    public void setTime(int hour, int minute, int position) { getEmotionList().setTime(hour,minute,position);}

    // returns the current date of an emotion
    public Date getTime(int position) {
        return getEmotionList().getEmotions().get(position).getDate();

    }

    // returns the number of occurrences of an emotion
    public Integer getOccurrence(String emotionName) {

        return getEmotionList().getOccurrences(emotionName);
    }

    // removes the selected emotion from the list
    public void deleteEmotion(Emotion emotion, int position) {
        getEmotionList().deleteEmotion(emotion, position);
    }

   // public void setEmotionList(ArrayList<Emotion> emotions) {
     //   emotionList.setEmotionList(emotions);
    //}

}