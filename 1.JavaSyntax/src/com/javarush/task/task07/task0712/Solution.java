package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++)
            strings.add(bufferedReader.readLine());

        int minSize = strings.get(0).length();
        int maxSize = strings.get(0).length();
        for(int i = 1; i < strings.size(); i++) {
            if (strings.get(i).length() < minSize)
                minSize = strings.get(i).length();
            if (strings.get(i).length() > maxSize)
                maxSize = strings.get(i).length();
        }
        for(String s: strings) {
            if (s.length() == minSize){
                System.out.println(s);
                break;
            }
            if (s.length() == maxSize){
                System.out.println(s);
                break;
            }
        }

    }
}
