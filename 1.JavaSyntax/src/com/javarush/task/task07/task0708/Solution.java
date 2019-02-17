package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        strings = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 5; i++)
            strings.add(bufferedReader.readLine());
        int maxSize = strings.get(0).length();
        for(int i = 1; i < strings.size(); i++) {
            if (strings.get(i).length() > maxSize)
                maxSize = strings.get(i).length();
        }
         for(String s: strings)
             if(s.length() == maxSize)
                 System.out.println(s);
        //напишите тут ваш код
    }
}
