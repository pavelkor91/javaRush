package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        array[0] = Integer.parseInt(reader.readLine());
        int maximum = array[0];
        int minimum = array[0];

        for (int i = 1; i < array.length; i++){
            array[i] = Integer.parseInt(reader.readLine());
            if (maximum < array[i])
                maximum = array[i];
            if (minimum > array[i])
                minimum = array[i];
        }

        //напишите тут ваш код

        System.out.print(maximum + " " + minimum);
    }
}
