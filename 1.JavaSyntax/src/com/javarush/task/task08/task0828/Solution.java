package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String,Integer> year = new HashMap<>();
        year.put("January" ,1);
        year.put("February" , 2);
        year.put("March" , 3);
        year.put("April" , 4);
        year.put("May" , 5);
        year.put("June" , 6);
        year.put("July" , 7);
        year.put("August" , 8);
        year.put("September" , 9);
        year.put("October" , 10);
        year.put("November" , 11);
        year.put("December" , 12);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String month = bufferedReader.readLine();
        System.out.println(month + " is the " + year.get(month) + " month");
        //напишите тут ваш код
    }
}
