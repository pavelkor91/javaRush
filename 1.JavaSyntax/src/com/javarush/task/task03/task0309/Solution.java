package com.javarush.task.task03.task0309;

/* 
Сумма 5 чисел
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        summ(5);
    }
    private static void summ(int number){
        int result = 0;
        for(int i = 1; i <= number; i++) {
            result += i;
            System.out.println(result);
        }
    }
}
