package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = null;
        String file2 = null;
        try {
            file1 = bufferedReader.readLine();
            file2 = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException e) {
        }
        byte[] data = null;
        try {
            FileInputStream fileReader = new FileInputStream(file1);
            data = new byte[fileReader.available()];
            fileReader.read(data);
            fileReader.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        String[] arrayString = new String(data).split(" ");

        String result = "";
        for (String s : arrayString) {
            result += (int) Math.round(Double.parseDouble(s)) + " ";
        }

        try {
            FileOutputStream fileWriter = new FileOutputStream(file2);
            fileWriter.write(result.getBytes());
            fileWriter.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }
}
