package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        int i = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        if (i < 1 || i > 999)
            return;

        if (i / 10 < 1 && i % 2 == 0)
            System.out.println("четное однозначное число");
        if (i / 10 < 10 && i / 10 >= 1 && i % 2 == 0)
            System.out.println("четное двузначное число");
        if (i / 10 < 100 && i / 10 >= 10 && i % 2 == 0)
            System.out.println("четное трехзначное число");

        if (i / 10 < 1 && i % 2 != 0)
            System.out.println("нечетное однозначное число");
        if (i / 10 < 10 && i / 10 >= 1 && i % 2 != 0)
            System.out.println("нечетное двузначное число");
        if (i / 10 < 100 && i / 10 >= 10 && i % 2 != 0)
            System.out.println("нечетное трехзначное число");
        //напишите тут ваш код
    }
}
