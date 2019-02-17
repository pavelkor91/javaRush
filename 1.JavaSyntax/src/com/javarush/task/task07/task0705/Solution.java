package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] bigArr = new int[20];
        for(int i = 0; i < bigArr.length; i++)
            bigArr[i] = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int[] array1 = new int[10];
        int[] array2 = new int[10];

        for(int i = 0; i < bigArr.length / 2; i++)
            array1[i] = bigArr[i];
        int index = 0;
        for(int i = bigArr.length / 2; i < bigArr.length; i++){
            array2[index] = bigArr[i];
            System.out.println(array2[index]);
            index++;
        }


    }
}
