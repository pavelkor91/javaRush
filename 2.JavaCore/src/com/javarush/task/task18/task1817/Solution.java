package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fileReader = new FileInputStream(args[0]);
            byte[] buffer = new byte[fileReader.available()];
            int allbytes = fileReader.available();
            fileReader.read(buffer);
            int spaceCount = 0;
            for(byte b: buffer){
                if((char)b == ' '){
                    spaceCount++;
                }
            }
            double result = (double)spaceCount / allbytes * 100;
            System.out.printf("%.2f", result);
            fileReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("FileNotFound");
        }
        catch (IOException e){}
    }
}
