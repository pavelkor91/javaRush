package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        // напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path = null;
        try {
            path = bufferedReader.readLine();
        }
        catch (IOException e){
            System.out.printf("IO Error");
        }

        InputStream  inputStreamReader = new FileInputStream(path);


        while (inputStreamReader.available() > 0){

            System.out.print((char)inputStreamReader.read());
        }
        bufferedReader.close();
        inputStreamReader.close();
    }
}