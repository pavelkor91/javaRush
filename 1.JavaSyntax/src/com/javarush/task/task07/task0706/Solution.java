package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] houses = new int[15];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < houses.length; i++)
            houses[i] = Integer.parseInt(bufferedReader.readLine());
        int even = houses[0];
        int odd = 0;
        for (int i = 1; i < houses.length; i++){
            if(i % 2 == 0)
                even += houses[i];
            else
                odd += houses[i];
        }

        if(even > odd)
            System.out.println("В домах с четными номерами проживает больше жителей.");
        else
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        //напишите тут ваш код
    }
}
