package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();

        String[] myArgs = outputStream.toString().split(" ");

        int a = Integer.parseInt(myArgs[0]);
        int b = Integer.parseInt(myArgs[2]);
        int result = 0;
        if(myArgs[1].equals("-"))
            result = a - b;
        if(myArgs[1].equals("+"))
            result = a + b;
        if(myArgs[1].equals("*"))
            result = a * b;

        String finalString = "" + a + " " + myArgs[1] + " " + b + " = " + result;

        System.setOut(printStream);

        System.out.println(finalString);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

