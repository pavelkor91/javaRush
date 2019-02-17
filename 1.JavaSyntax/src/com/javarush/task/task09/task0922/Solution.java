package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
       SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       String read = bufferedReader.readLine();
       Date date = simpleDateFormat.parse(read);
        System.out.println(simpleDateFormat1.format(date).toUpperCase());
    }
}
