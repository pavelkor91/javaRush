package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++)
            strings.add(bufferedReader.readLine());
        for(int i = 1; i < strings.size(); i++){
            if(strings.get(i).length() < strings.get(i-1).length())
                System.out.println(i);
        }

        //напишите тут ваш код
    }
}

