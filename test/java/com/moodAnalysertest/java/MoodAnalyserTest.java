package com.moodAnalysertest.java;

import com.moodAnalyser.java.MoodAnalyser;
import com.moodAnalyser.java.MoodAnalyserException;
import com.moodAnalyser.java.MoodAnalyserFactory;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
public class MoodAnalyserTest {
    @Test
    public void givenMoodAnalyserClassNameShouldReturnMoodAnalyserObjectUSingDefaultConstructor(){
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor();
            MoodAnalyser anotherMoodAnalyserObject = (MoodAnalyser) MoodAnalyserFactory.createMoodAnalyserObject(moodAnalyserConstructor);
            Assert.assertEquals(true,  moodAnalyser.isEqualsObject(anotherMoodAnalyserObject));
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenMoodAnalyserClassNameShouldReturnMoodAnalyserObjectUSingParameterizeConstructor(){
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor(String.class);
            MoodAnalyser anotherMoodAnalyserObject = (MoodAnalyser) MoodAnalyserFactory.createMoodAnalyserObject(moodAnalyserConstructor,"i am happy");
            Assert.assertEquals(true,  moodAnalyser.isEqualsObject(anotherMoodAnalyserObject));
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenImproperConstructorParameterShouldThrowMoodAnalyserException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor(Integer.class);
            MoodAnalyserFactory.createMoodAnalyserObject(moodAnalyserConstructor);

        } catch ( MoodAnalyserException e) {
            Assert.assertEquals("NO_SUCH_METHOD_ERROR", e.getMessage());
        }
    }
}
