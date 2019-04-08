package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = consoleReader.readLine();
        consoleReader.close();

        FileReader fileReader = new FileReader(filePath);
        BufferedReader fileReaderBuffer = new BufferedReader(fileReader);

        while (fileReaderBuffer.ready()){
            String fullString = fileReaderBuffer.readLine();
            String[] data = fullString.split(" ");
            int count = 0;
            for(String s: words)
            {
                for(String peace: data){
                    if(s.equals(peace))
                        count++;
                }
            }
            if(count == 2)
                System.out.println(fullString);
        }
        fileReader.close();

    }
}
