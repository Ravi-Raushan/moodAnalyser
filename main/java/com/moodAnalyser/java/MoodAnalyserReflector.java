package com.moodAnalyser.java;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserReflector {
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
        } catch (InstantiationException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.OBJECT_CREATION_ISSUE,"OBJECT_CREATION_ISSUE");
        } catch (InvocationTargetException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.METHOD_INVOCATION_ISSUE,"METHOD_INVOCATION_ISSUE");
        } catch (IllegalAccessException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_ACCESS,"NO_ACCESS");
        }
    }
    public static Object invokeMethod(Object moodAnalyseObject, String methodName) throws MoodAnalyserException {
        try {
            return moodAnalyseObject.getClass().getMethod(methodName).invoke(moodAnalyseObject);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD, "NO_SUCH_METHOD_ERROR");
        } catch (IllegalAccessException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_ACCESS, "NO_ACCESS");
        } catch (InvocationTargetException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.METHOD_INVOCATION_ISSUE, "METHOD_INVOCATION_ISSUE");
        }
    }
}
