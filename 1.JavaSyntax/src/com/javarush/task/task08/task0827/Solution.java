package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Date date1 = df.parse(date);
        Date date2 = new Date();
        date2.setYear(date1.getYear());
        date2.setHours(0);
        date2.setMinutes(0);
        date2.setSeconds(0);
        date2.setDate(1);
        date2.setMonth(0);
        long msDistance = date1.getTime() - date2.getTime();
        long msDay = 24 * 60 * 60 * 1000;
        int dayCount = (int) (msDistance/msDay);
        return dayCount % 2 == 0 ? false : true;
    }
}
