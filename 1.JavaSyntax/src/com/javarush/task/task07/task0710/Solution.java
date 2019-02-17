package com.javarush.task.task07.task0710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
В начало списка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<String>();
        for(int i = 0; i < 10; i++)
            strings.add(0,bufferedReader.readLine());
        for (String s: strings)
            System.out.println(s);
    }
}
