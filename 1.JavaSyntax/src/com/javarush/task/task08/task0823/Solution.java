package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        boolean check = true;
        for(char c: s.toCharArray()) {
            if (check){
                c = Character.toUpperCase(c);
                check = false;
            }
            if (c == ' ')
                check = true;
            System.out.print(c);
        }


        //напишите тут ваш код
    }
}
