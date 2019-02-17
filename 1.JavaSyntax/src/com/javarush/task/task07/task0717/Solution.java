package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < 10; i++)
            list.add(bufferedReader.readLine());

        ArrayList<String> result = doubleValues(list);

        result.forEach(System.out::println);
        // Вывести на экран result
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        ArrayList<String> strings = new ArrayList<String>();
        for(String s:list)
        {
            strings.add(s);
            strings.add(s);
        }
        return strings;
    }
}
