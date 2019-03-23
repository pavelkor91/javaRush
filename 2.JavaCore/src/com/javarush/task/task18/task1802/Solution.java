package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = null;
        try {
            filePath = bufferedReader.readLine();
        }
        catch (IOException e){}

        FileInputStream fileInputStream = new FileInputStream(filePath);

        int min = fileInputStream.read();
        while (fileInputStream.available() > 0){
            int tmp = fileInputStream.read();
            if(tmp < min)
                min = tmp;
        }
        System.out.println(min);
        bufferedReader.close();
        fileInputStream.close();
    }
}
