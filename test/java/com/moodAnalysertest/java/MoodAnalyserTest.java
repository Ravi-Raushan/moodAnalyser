package com.moodAnalysertest.java;

import com.moodAnalyser.java.MoodAnalyser;
import com.moodAnalyser.java.MoodAnalyserException;
import com.moodAnalyser.java.MoodAnalyserFactory;
import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserTest {
    @Test
    public void givenMoodAnalyserClassNameShouldReturnMoodAnalyserObject(){
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        try {
                MoodAnalyser anotherMoodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject("com.moodAnalyser.java.MoodAnalyser",String.class);
                Assert.assertEquals(true,  moodAnalyser.isEqualsObject(anotherMoodAnalyserObject));
        } catch (MoodAnalyserException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenClassNameImproperShouldThrowMoodAnalyserException() {
        try {
             MoodAnalyserFactory.createMoodAnalyserObject("com.moodAnalyser.java.MindAnalyser",String.class);
             System.out.println(" not exception");
        } catch (MoodAnalyserException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            Assert.assertEquals("NO_SUCH_CLASS_ERROR", e.getMessage());
        }
    }
    @Test
    public void givenImproperConstructorParameterShouldThrowMoodAnalyserException() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyserObject("com.moodAnalyser.java.MoodAnalyser",Integer.class);
        } catch (MoodAnalyserException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            Assert.assertEquals("NO_SUCH_METHOD_ERROR", e.getMessage());
        }
    }
}
