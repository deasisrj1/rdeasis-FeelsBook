package com.example.rdeasis_feelsbook;

public class EmotionListController  {
    private static EmotionList emotionList = null;

    static public EmotionList getEmotionList() {
        if (emotionList == null) {
            emotionList = new EmotionList();
        }
        return emotionList;
    }

    public void addEmotion(Emotion emotion){
        getEmotionList().addEmotion(emotion);
    }


}