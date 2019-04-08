package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        while (bufferedReader.ready()){
            String[] words = bufferedReader.readLine().split(" ");
            for(String s: words){
                if(s.matches(".*\\d+.*"))
                {
                    fileWriter.write(s + " ");
                }
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
