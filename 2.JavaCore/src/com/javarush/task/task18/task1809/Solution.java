package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inFile = null;
        String outFile = null;

        try {
            inFile = bufferedReader.readLine();
            outFile = bufferedReader.readLine();
        }
        catch (IOException e ){}

        try {
            FileInputStream fileInputStream = new FileInputStream(inFile);
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            byte[] buff = new byte[fileInputStream.available()];
            fileInputStream.read(buff);
            for(int i = buff.length - 1; i >= 0; i--){
                fileOutputStream.write(buff[i]);
            }
            fileInputStream.close();
            fileOutputStream.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}


    }
}
