package com.example.rdeasis_feelsbook;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Emotion implements Serializable {
    private String emotionName;
    protected ArrayList<Date> date = new ArrayList<Date>();
    private ArrayList<String> commentList = new ArrayList<String>();


    public Emotion(String emotionName, Date date){
        this.emotionName = emotionName;
        if (this.date.isEmpty()) {
            this.date.add(date);
        }

    }

    public Emotion(String emotionName, String comment, Date date){
        // Log.d("addEmotion", "Emotion added");
        this.emotionName = emotionName;
        this.commentList.add(comment);
        if (this.date.isEmpty()) {
            this.date.add(date);
        }
    }

    public void addComment(String comment){
        this.commentList.add(comment);
    }

    // Sets/Edits the Time of emotion
    public void setTime(int hour, int minute){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.DATE, this.date.get(0).getDate());
        cal.set(Calendar.MONTH, this.date.get(0).getMonth());
        this.date.remove(0);
        this.date.add(cal.getTime());
    }

    public String getEmotionName(){
        return this.emotionName;
    }

    public Date getDate(){
        return this.date.get(0);
    }

    public ArrayList<String> getCommentList(){
        return this.commentList;
    }


}
