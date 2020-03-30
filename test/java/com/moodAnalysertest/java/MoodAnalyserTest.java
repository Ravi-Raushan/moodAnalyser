package com.moodAnalysertest.java;
import com.moodAnalyser.java.MoodAnalyserException;
import com.moodAnalyser.java.MoodAnalyserReflector;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
public class MoodAnalyserTest {
    @Test
    public void setHappyMessageWithReflectorShouldReturnHappy() {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserReflector.getConstructor();
            Object obj = MoodAnalyserReflector.createMoodAnalyserObject(moodAnalyserConstructor);
            MoodAnalyserReflector.setFieldValue(obj, "message", "I m in happy Mood");
            Object mood = MoodAnalyserReflector.invokeMethod(obj, "analyseMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void SetFieldWhenImproperShouldThrowExceptionWithNoSuchField() {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserReflector.getConstructor();
            Object obj = MoodAnalyserReflector.createMoodAnalyserObject(moodAnalyserConstructor);
            MoodAnalyserReflector.setFieldValue(obj, "myMessage", "I m in happy Mood");
            Object mood = MoodAnalyserReflector.invokeMethod(obj, "analyseMood");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("NO_SUCH_FIELD", e.getMessage());
        }
    }
    @Test
    public void SettingNullMessageWithReflectorShouldThrowException() {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserReflector.getConstructor();
            Object obj = MoodAnalyserReflector.createMoodAnalyserObject(moodAnalyserConstructor);
            MoodAnalyserReflector.setFieldValue(obj, "message", null);
            Object mood = MoodAnalyserReflector.invokeMethod(obj, "analyseMood");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("METHOD_INVOCATION_ISSUE", e.getMessage());
        }
    }

}
