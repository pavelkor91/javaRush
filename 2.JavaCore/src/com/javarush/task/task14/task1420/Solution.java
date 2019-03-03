package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = 0;
        int b = 0;
        a = Integer.parseInt(bufferedReader.readLine());
        b = Integer.parseInt(bufferedReader.readLine());
        if (a <= 0 || b <= 0 || a % 1 != 0 || b % 1 != 0){
                 throw new Exception();
        }

        while (b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        System.out.println(a);
    }
}
