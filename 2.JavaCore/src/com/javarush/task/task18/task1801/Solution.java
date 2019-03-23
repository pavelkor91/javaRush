package com.javarush.task.task18.task1801;

import java.io.*;

/* 
Максимальный байт
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

        int max = 0;
        while (fileInputStream.available() > 0){
            int tmp = fileInputStream.read();
            if(tmp > max)
                max = tmp;
        }
        System.out.println((char)max);
        bufferedReader.close();
        fileInputStream.close();
    }
}
