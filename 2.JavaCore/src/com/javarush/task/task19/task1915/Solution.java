package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        try {
            fileName = bufferedReader.readLine();
            bufferedReader.close();
        }
        catch (IOException e){}


        PrintStream printStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(printStream);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(result.getBytes());
            fileOutputStream.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

