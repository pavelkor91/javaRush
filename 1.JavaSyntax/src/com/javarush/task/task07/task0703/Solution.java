package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int size = 10;
        String[] strings = new String[10];
        int[] array = new int[10];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = new BufferedReader(new InputStreamReader(System.in)).readLine();
            array[i] = strings[i].length();
            System.out.println(array[i]);
        }



    }
}
