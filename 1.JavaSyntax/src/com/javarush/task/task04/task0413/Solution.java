package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] days = new String[]{"",
                "понедельник",
                "вторник",
                "среда",
                "четверг",
                "пятница",
                "суббота",
                "воскресенье"
        };
        int number = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        if(number > 0 && number < 8)
            System.out.println(days[number]);
        else
            System.out.println("такого дня недели не существует");
    }
}