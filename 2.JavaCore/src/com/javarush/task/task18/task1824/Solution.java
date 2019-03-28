package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        FileInputStream fileInputStream = null;
        try {

            while (true){
                fileName = bufferedReader.readLine();
                fileInputStream = new FileInputStream(fileName);
                fileInputStream.read();
                fileInputStream.close();
            }
        }
        catch (FileNotFoundException e){
            System.out.println(fileName);
        }
        catch (IOException e){}
    }
}
