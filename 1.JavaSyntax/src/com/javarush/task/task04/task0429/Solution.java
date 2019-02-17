package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[3];
        int pos = 0;
        int neg = 0;
        for(int i = 0; i < array.length; i++){
            array[i] = Integer.parseInt(bufferedReader.readLine());
            if(array[i] > 0)
                pos++;
            if(array[i] < 0)
                neg++;
        }
        System.out.println("количество отрицательных чисел: " + neg);
        System.out.println("количество положительных чисел: " + pos);
    }
}
