package com.moodAnalyser.java;

public class MoodAnalyser {
    public String analyseMood(String message) {
            if (message.contains("sad"))
                return "SAD";
            return "HAPPY";
    }
}
