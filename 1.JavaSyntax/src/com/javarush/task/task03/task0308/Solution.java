package com.javarush.task.task03.task0308;

/* 
Произведение 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(factorial(10));
    }
    private static int factorial(int number){
        int result = 1;
        for(int i = 1; i <= number; i++)
            result *= i;
        return result;
    }
}
