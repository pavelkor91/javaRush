package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = new int[3];
        for (int i = 0; i < array.length; i++)
            array[i] = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int tmp = 0;
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++)
            {
                if(i == j) continue;
                if (array[i] == array[j])
                    tmp++;
            }
        }
        if (tmp != 0){
            tmp = 0;
            for(int i = 0; i < array.length; i++){
                for (int j = 0; j < array.length; j++)
                {
                    if(i == j) continue;
                    if (array[i] != array[j])
                        tmp++;
                }
                if (tmp >= 2) {
                    System.out.println(i + 1);
                    break;
                }
                else
                    tmp = 0;
            }
        }
        else return;
        //напишите тут ваш код
    }
}
