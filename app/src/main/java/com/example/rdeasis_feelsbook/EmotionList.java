package com.example.rdeasis_feelsbook;

import java.util.ArrayList;

public class EmotionList {

    public ArrayList<Emotion> emotionList;

    public EmotionList(){
        emotionList = new ArrayList<Emotion>();
    }

    public ArrayList<Emotion> getEmotions() {
        return emotionList;
    }

    public void addEmotion(Emotion emotion) {
        emotionList.add(emotion);
    }

    public void deleteEmotion(Emotion emotion) {
        emotionList.remove(emotion);
    }

}
