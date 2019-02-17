package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        String s = new BufferedReader(new InputStreamReader(System.in)).readLine().replace(" ", "");
        String a = "", b = "";

        for (Character ch : s.toCharArray()) {
            if (isVowel(ch)) {
                a += ch + " ";//напишите тут ваш код
            } else {
                b += ch + " ";
            }
        }
        System.out.println(a);
        System.out.println(b);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}