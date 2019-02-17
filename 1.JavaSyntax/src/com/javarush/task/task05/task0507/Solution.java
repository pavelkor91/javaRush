package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        double result = 0;
        while (true){
            int tmp = Integer.parseInt(bufferedReader.readLine());
            if(tmp != -1)
            {
                count++;
                result += tmp;
            }
            else
                break;
        }
        System.out.println(result / count);
        //напишите тут ваш код
    }
}

