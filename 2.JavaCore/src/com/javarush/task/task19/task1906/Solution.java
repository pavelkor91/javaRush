package com.javarush.task.task19.task1906;

/* 
Четные символы
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
            FileWriter fileWriter = new FileWriter(secondFile);

            int count = 1;
            while (fileReader.ready()){
                int symbol = fileReader.read();
                if(count % 2 == 0){
                    fileWriter.write(symbol);
                }
                count++;
            }

            fileReader.close();
            fileWriter.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}



    }
}
