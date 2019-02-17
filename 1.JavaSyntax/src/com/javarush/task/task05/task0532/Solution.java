package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n < 1)
            return;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        int maximum = array[0];
        for (int i : array)
            if (i > maximum)
                maximum = i;

        //напишите тут ваш код

        System.out.println(maximum);
    }
}
