package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {

        Arrays.sort(array);
        int[] tmp = new int[20];
        int counter = 0;
        for(int i = tmp.length-1; i >= 0; i--) {
            tmp[counter] = array[i];
            counter++;
        }
        for(int i = 0; i < array.length; i++){
            array[i] = tmp[i];
        }
        //напишите тут ваш код
    }
}
