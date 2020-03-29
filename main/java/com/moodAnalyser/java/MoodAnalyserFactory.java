package com.moodAnalyser.java;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static Constructor<?> getConstructor(Class<?> ...param) throws MoodAnalyserException{
        try{
            Class<?> moodAnalyserClass = Class.forName("com.moodAnalyser.java.MoodAnalyser");
            return moodAnalyserClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS,"NO_SUCH_CLASS_ERROR");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,"NO_SUCH_METHOD_ERROR");
        }
    }
    public static Object createMoodAnalyserObject(Constructor<?> constructor,Object ...message) throws MoodAnalyserException {
        try {
            return constructor.newInstance(message);

        } catch (IllegalAccessException e) {
            throw new MoodAnalyserException("IllegalAccessException");
        } catch (InstantiationException | InvocationTargetException e) {
            throw new MoodAnalyserException("InstantiationException | InvocationTargetException e");
        }
    }
}
