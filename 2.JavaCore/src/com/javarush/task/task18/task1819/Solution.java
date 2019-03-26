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

        byte[] firstFile = readFile(file1);
        byte[] secondFile = readFile(file2);
        byte[] fullBuffer = new byte[firstFile.length + secondFile.length];
        System.arraycopy(secondFile, 0, fullBuffer, 0, secondFile.length);
        System.arraycopy(firstFile, 0, fullBuffer, firstFile.length, secondFile.length);

        writeFile(file1, fullBuffer);

    }

    public static byte[] readFile(String filePath){
        byte[] buffer = null;
        try {
            FileInputStream fileReader = new FileInputStream(filePath);
            buffer = new byte[fileReader.available()];
            fileReader.read(buffer);
            fileReader.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}
        return buffer;
    }

    public static void writeFile(String filePath, byte[] buffer){
        try {
            FileOutputStream fileWriter = new FileOutputStream(filePath);
            fileWriter.write(buffer);
            fileWriter.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }
}
