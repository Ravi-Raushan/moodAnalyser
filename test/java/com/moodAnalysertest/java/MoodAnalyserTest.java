package com.moodAnalysertest.java;

import com.moodAnalyser.java.MoodAnalyser;
import com.moodAnalyser.java.MoodAnalyserException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenEmptyMoodShouldThrowMoodAnalyserException(){
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
            String mood = moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("EMPTY MOOD", e.getMessage());
        }
    }
    @Test
    public void givenNullMoodShouldThrowMoodAnalyserException(){
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            String mood = moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("NULL MOOD", e.getMessage());
        }
    }
}
