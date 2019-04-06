package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = null;
        String secondFile = null;

        try {

            firstFile = bufferedReader.readLine();
            secondFile = bufferedReader.readLine();
            bufferedReader.close();
        }
        catch (IOException e){}

        try {
            FileReader fileReader = new FileReader(firstFile);
            bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(secondFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            while (bufferedReader.ready()){
                String s = bufferedReader.readLine().replaceAll("\\.","!");
                bufferedWriter.write(s);
            }
            bufferedReader.close();
            bufferedWriter.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }
}
