package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = null;
        String file2 = null;
        String file3 = null;
        try {
            file1 = bufferedReader.readLine();
            file2 = bufferedReader.readLine();
            file3 = bufferedReader.readLine();
            bufferedReader.close();
        }
        catch (IOException e){}
        try {
            FileInputStream fileReader = new FileInputStream(file2);
            FileOutputStream fileWriter = new FileOutputStream(file1);
            byte[] buffer = new byte[fileReader.available()];
            fileReader.read(buffer);
            fileReader.close();
            fileWriter.write(buffer);
            fileWriter.close();
            fileReader = new FileInputStream(file3);
            buffer = new byte[fileReader.available()];
            fileReader.read(buffer);
            fileReader.close();
            fileWriter = new FileOutputStream(file1, true);
            fileWriter.write(buffer);
            fileWriter.close();

        }
        catch (FileNotFoundException e){}
        catch (IOException e){}



    }
}
