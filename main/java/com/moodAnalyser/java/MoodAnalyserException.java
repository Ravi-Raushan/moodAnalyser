package com.moodAnalyser.java;

public class MoodAnalyserException extends Exception{
   public enum ExceptionType{
        ENTERED_NULL,ENTERED_EMPTY,NO_SUCH_CLASS,NO_SUCH_METHOD,NO_ACCESS
       ,METHOD_INVOCATION_ISSUE,OBJECT_CREATION_ISSUE,NO_SUCH_FIELD
    }
    public ExceptionType type;
    public MoodAnalyserException(ExceptionType type,String message){
             super(message);
             this.type=type;
    }
}
