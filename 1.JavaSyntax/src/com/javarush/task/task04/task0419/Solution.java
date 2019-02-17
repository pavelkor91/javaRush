package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = new int[4];
        for(int i = 0; i < array.length; i++)
            array[i] = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int result = array[0];
        for (int i:array)
            if(i > result)
                result = i;
        System.out.println(result);
        //напишите тут ваш код
    }
}
