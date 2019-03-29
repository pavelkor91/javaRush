package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String finalFile = null;
        int countOfFiles = 1;
        try {
            String s = bufferedReader.readLine();;
            finalFile = s.split(".part")[0];
            while (!(s = bufferedReader.readLine()).equals("end")){
                countOfFiles++;
            }
            bufferedReader.close();
        }
        catch (IOException e){}

        File file = new File(finalFile);
        try {
            file.createNewFile();
            FileOutputStream fileWriter = new FileOutputStream(file, true);
            byte[] buffer = null;
            for (int i = 0; i < countOfFiles; i++) {
                FileInputStream fileReader = new FileInputStream(finalFile + ".part" + (i + 1));
                buffer = new byte[fileReader.available()];
                fileReader.read(buffer);
                fileReader.close();
                fileWriter.write(buffer);
            }
            fileWriter.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }
}
