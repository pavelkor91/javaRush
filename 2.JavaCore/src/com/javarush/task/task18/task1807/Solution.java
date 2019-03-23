package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader readFileName = new BufferedReader(new InputStreamReader(System.in));
        String filePath = null;
        try {
            filePath = readFileName.readLine();
        }
        catch (IOException e){}

        int count = 0;

        FileInputStream fileReader = new FileInputStream(filePath);
        try {
            while (fileReader.available() > 0){
                if(fileReader.read() == 44){
                    count++;
                }
            }
            fileReader.close();
        }
        catch (IOException e){}


        System.out.println(count);
    }
}
