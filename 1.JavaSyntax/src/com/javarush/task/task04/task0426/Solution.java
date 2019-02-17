package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int i = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        if(i > 0 && i % 2 == 0)
            System.out.println("положительное четное число");
        if(i < 0 && i % 2 == 0)
            System.out.println("отрицательное четное число");
        if(i > 0 && i % 2 != 0)
            System.out.println("положительное нечетное число");
        if(i < 0 && i % 2 != 0)
            System.out.println("отрицательное нечетное число");
        if(i == 0)
            System.out.println("ноль");
        //напишите тут ваш код
    }
}
