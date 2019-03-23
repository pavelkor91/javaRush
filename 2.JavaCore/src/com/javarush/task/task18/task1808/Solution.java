package com.javarush.task.task18.task1808;

/* 
Разделение файла
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
            FileInputStream fileReader = new FileInputStream(file1);
            FileOutputStream fileWriter = new FileOutputStream(file2);
            int allBytsCount = fileReader.available();
            int middle = allBytsCount / 2 + allBytsCount % 2;
            byte[] buffer = new byte[allBytsCount];
            fileReader.read(buffer);
            fileReader.close();
            fileWriter.write(buffer, 0, middle);
            fileWriter.close();
            fileWriter = new FileOutputStream(file3);
            fileWriter.write(buffer, middle, allBytsCount - middle);
            fileWriter.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}

    }
}
