package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path = null;
        try {
            path = bufferedReader.readLine();
        }
        catch (IOException e){
            System.out.printf("IO Error");
        }

        BufferedWriter outputStream = new BufferedWriter(new FileWriter(path));


        String txt = "";
        do{
            txt = bufferedReader.readLine();
            outputStream.write(txt + "\n");

        }
        while (!txt.equals("exit"));
        bufferedReader.close();
        outputStream.close();


    }
}
