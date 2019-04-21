package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File inFile = new File(args[0]);
        File outFile = new File(args[1]);
        FileInputStream fileInputStream = new FileInputStream(inFile);
        FileOutputStream fileOutputStream = new FileOutputStream(outFile);
        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        byte[] date = new byte[fileInputStream.available()];
        fileInputStream.read(date);
        String tmp = new String(date, windows1251);
        date = tmp.getBytes(utf8);
        fileOutputStream.write(date);
        fileInputStream.close();
        fileOutputStream.close();

    }
}
