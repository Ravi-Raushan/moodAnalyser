package com.moodAnalysertest.java;
import com.moodAnalyser.java.MoodAnalyserException;
import com.moodAnalyser.java.MoodAnalyserReflector;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
public class MoodAnalyserTest {
    @Test
    public void givenHappyMessageUsingReflectionWhenProperShouldReturnHappyMood() {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserReflector.getConstructor(String.class);
            Object obj = MoodAnalyserReflector.createMoodAnalyserObject(moodAnalyserConstructor,"i am in happy mood");
            Object mood = MoodAnalyserReflector.invokeMethod(obj, "analyseMood");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenHappyMessageWhenImProperMethodShouldThrowMoodAnalyserException() {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserReflector.getConstructor(String.class);
            Object obj = MoodAnalyserReflector.createMoodAnalyserObject(moodAnalyserConstructor,"i am in happy mood");
            MoodAnalyserReflector.invokeMethod(obj, "analyseMind");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("NO_SUCH_METHOD_ERROR",e.getMessage());
        }
    }
}
