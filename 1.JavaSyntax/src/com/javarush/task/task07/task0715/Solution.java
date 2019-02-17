package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("мама");
        strings.add("именно");
        strings.add("мыла");
        strings.add("именно");
        strings.add("раму");
        strings.add("именно");
        strings.forEach(System.out::println);

        //напишите тут ваш код
    }
}
