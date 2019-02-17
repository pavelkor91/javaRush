package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[3];
        for(int i = 0; i < array.length; i++)
            array[i] = Integer.parseInt(bufferedReader.readLine());
        Arrays.sort(array);
        System.out.println(array[array.length/2]);
    }
}
