package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        /*int result = number % 10;
        if (number % 10 <= 0)
            return  result;
        else
            result += sumDigitsInNumber(number/10);
       return result;
        //напишите тут ваш код*/
        int result = 0;
        while (number > 0)
        {
            result += number % 10;
            number = number / 10;
        }
        return  result;
    }
}