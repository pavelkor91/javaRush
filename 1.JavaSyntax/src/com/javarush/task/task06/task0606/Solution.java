package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        int i = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        while (i > 0){
            int tmp = i % 10;

            if(tmp % 2 == 0)
                even++;
            else
                odd++;

            i /= 10;
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
