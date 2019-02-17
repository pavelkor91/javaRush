package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());

        if(a == b) {
            System.out.print(a + " " + b);
            if (a == c)
                System.out.print(" " + c);
            return;
        }
        if(b == c)
            System.out.print(b + " " + c);
        if (a == c)
            System.out.print(a + " " + c);
        //напишите тут ваш код
    }
}