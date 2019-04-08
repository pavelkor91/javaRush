package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = consoleReader.readLine();
        consoleReader.close();

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedFileReader = new BufferedReader(fileReader);

        while (bufferedFileReader.ready()){
            StringBuilder sb = new StringBuilder();
            sb.append(bufferedFileReader.readLine());
            System.out.println(sb.reverse().toString());
        }

        fileReader.close();
    }
}
