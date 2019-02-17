package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<String>();
        for (int i = 0; i < 5; i++)
            strings.add(bufferedReader.readLine());
        String tmp;
        for(int i = 0; i < 13; i++){
            tmp = strings.get(strings.size()-1);
            strings.remove(strings.size()-1);
            strings.add(0,tmp);
        }
        for(String s: strings)
            System.out.println(s);

    }
}
