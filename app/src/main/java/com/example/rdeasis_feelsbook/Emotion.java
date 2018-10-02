package com.example.rdeasis_feelsbook;

import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

public class Emotion {
    private String emotionName;
    private Date date = new Date();
    private ArrayList<String> commentList = new ArrayList<String>();

    public Emotion(String emotionName){
        Log.d("addEmotion","Emotion added1");
        this.emotionName = emotionName;

    }

    public Emotion(String emotionName, String comment){
        Log.d("addEmotion", "Emotion added");
        this.emotionName = emotionName;
        this.commentList.add(comment);
    }

    public void addComment(String comment){
        this.commentList.add(comment);

    }

    public void setDate(Date date){
        this.date = date;
    }

    public String getEmotionName(){
        return this.emotionName;
    }

    public Date getDate(){
        return this.date;
    }

    public ArrayList<String> getCommentList(){
        return this.commentList;
    }

}
