package com.javarush.task.task18.task1819;

/* 
Объединение файлов
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
        }
        catch (IOException e){}

        byte[] firstFile = null;
        try {
            FileInputStream fileReader = new FileInputStream(file1);
            firstFile = new byte[fileReader.available()];
            fileReader.read(firstFile);
            fileReader.close();

        }
        catch (FileNotFoundException e){}
        catch (IOException e){}

        byte[] secondFile = null;
        try {
            FileInputStream fileReader = new FileInputStream(file2);
            secondFile = new byte[fileReader.available()];
            fileReader.read(secondFile);
            fileReader.close();

        }
        catch (FileNotFoundException e){}
        catch (IOException e){}

        //byte[] fullBuffer = new byte[firstFile.length + secondFile.length];
       // System.arraycopy(secondFile, 0, fullBuffer, 0, secondFile.length);
       // System.arraycopy(firstFile, 0, fullBuffer, firstFile.length, secondFile.length);

        try {
            FileOutputStream fileWriter = new FileOutputStream(file1);
            fileWriter.write(secondFile);
            fileWriter.write(firstFile);
            fileWriter.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}

    }
}
