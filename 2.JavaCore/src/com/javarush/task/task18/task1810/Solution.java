package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String fileName = null;
            try{
                fileName = bufferedReader.readLine();
                FileInputStream fileInputStream = new FileInputStream(fileName);
                if(fileInputStream.available() < 1000){
                    fileInputStream.close();
                    bufferedReader.close();
                    throw new DownloadException();
                }
            }
            catch (IOException e){}
        }

    }

    public static class DownloadException extends Exception {

    }
}
