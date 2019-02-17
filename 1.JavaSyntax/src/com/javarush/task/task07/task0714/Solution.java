package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++)
            strings.add(bufferedReader.readLine());
        strings.remove(2);
        for(int i = strings.size() - 1; i >= 0; i--)
            System.out.println(strings.get(i));
        //напишите тут ваш код
    }
}


