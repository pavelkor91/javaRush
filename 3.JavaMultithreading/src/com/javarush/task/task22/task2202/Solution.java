package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if(string == null)
            throw new TooShortStringException();

        String[] words = string.split(" ");

        if(words.length < 5)
            throw new TooShortStringException();

        StringBuilder sb = new StringBuilder();
        int i = 1;
        while (i < words.length){

            if(i > 4)
                break;
            sb.append(words[i]);
            sb.append(" ");
            i++;
        }
        return sb.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
