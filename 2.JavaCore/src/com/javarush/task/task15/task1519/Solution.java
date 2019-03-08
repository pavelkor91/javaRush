package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while (true){
            s = bufferedReader.readLine();
            if(s.equals("exit"))
                break;
            else {

                try {
                    if(s.contains("."))
                        print(Double.parseDouble(s));
                    else if (Integer.parseInt(s) < 128 && Integer.parseInt(s) > 0)
                        print(Short.parseShort(s));
                    else
                        print(Integer.parseInt(s));
                }
                catch (NumberFormatException e){
                    print(s);
                }

            }
        }

        //напиште тут ваш код
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
