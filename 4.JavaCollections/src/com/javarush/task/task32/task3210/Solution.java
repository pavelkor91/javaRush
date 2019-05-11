package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException{
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        long number = Long.parseLong(args[1]);
        byte[] buffer = new byte[args[2].length()];
        raf.seek(number);
        raf.read(buffer, 0, buffer.length);
        String tmp = new String(buffer);
        raf.seek(raf.length());
       if(tmp.equals(args[2])){
           raf.write("true".getBytes());
       }
       else {
           raf.write("false".getBytes());
       }
       raf.close();

    }
}
