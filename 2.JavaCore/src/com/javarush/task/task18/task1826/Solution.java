package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {

        try {
            FileInputStream fileReader = new FileInputStream(args[1]);
            FileOutputStream fileWriter = new FileOutputStream(args[2]);
            byte[] buffer = new byte[fileReader.available()];
            fileReader.read(buffer);
            fileReader.close();
            if(args[0].equals("-e")){
                for (int i = 0; i < buffer.length; i++){
                    if(buffer[i] == 127)
                    {
                        buffer[i] = -128;
                    }
                    else
                        buffer[i] = ++buffer[i];
                }
            }
            if(args[0].equals("-d")){
                for (int i = 0; i < buffer.length; i++){
                    if(buffer[i] == -128)
                    {
                        buffer[i] = 127;
                    }
                    else
                        buffer[i] = --buffer[i];
                }
            }
            fileWriter.write(buffer);
            fileWriter.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }

}
