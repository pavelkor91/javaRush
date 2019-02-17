package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = new int[3];
        for(int i = 0; i < array.length; i++)
            array[i] = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int tmp = 0;
        for(int i = array.length-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(array[j] < array[i]) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }

            }
        }
        for(int i: array)
            System.out.print(i + " ");
        //напишите тут ваш код
    }
}
