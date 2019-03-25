package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fileReader = new FileInputStream(args[0]);
            byte[] buffer = new byte[fileReader.available()];
            fileReader.read(buffer);
            int count = 0;
            for(byte b: buffer){
                if((char)b >= 'a' && (char)b <= 'z' || (char)b >= 'A' && (char)b <= 'Z'){
                    count++;
                }
            }

            System.out.println(count);
            fileReader.close();
         }
        catch (FileNotFoundException e){
            System.out.println("FileNotFound");
        }
        catch (IOException e){}

    }
}
