package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {


        if(telNumber == null || telNumber.isEmpty()) return false;

        Pattern p = Pattern.compile("\\d");
        Matcher find = p.matcher(telNumber);
        int count = 0;
        while (find.find()) count++;
        if ((telNumber.split("")[0].equals("+") && count == 12) || count == 10) {
            if (telNumber.matches("^\\+?\\d+\\(?\\d{3}\\)?(\\d+-\\d){0,2}\\d+")) return true;
        }


        return false;
    }

    public static void main(String[] args) {

    }
}
