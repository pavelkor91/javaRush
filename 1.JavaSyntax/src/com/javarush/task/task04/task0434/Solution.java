package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int i = 1;
        int j = 1;
        while (i <= 10){
            while (j <= 10) {
                System.out.print(i * j + " ");
                j++;
            }
            System.out.println("");
            j = 1;
            i++;
        }

    }
}
