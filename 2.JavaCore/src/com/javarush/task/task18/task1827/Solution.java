package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        if(args.length < 4)
            return;

        BufferedReader readFileName = new BufferedReader(new InputStreamReader(System.in));
        String filePath = readFileName.readLine();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        readFileName = new BufferedReader(new InputStreamReader(fileInputStream));

        String lastString = null;
        int tmp;
        int id = 0;
        while (readFileName.ready()){
            lastString = readFileName.readLine();
            tmp = Integer.parseInt(lastString.substring(0,8).trim());
            if(tmp > id)
                id = tmp;
        }
        id++;
        System.out.println(id);
        fileInputStream.close();
        readFileName.close();



        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(id);
        for(int i = stringBuilder.length(); i < 8; i++){
            stringBuilder.append(" ");
        }
        stringBuilder.append(args[1]);
        for(int i = stringBuilder.length(); i < 38; i++)
            stringBuilder.append(" ");
        stringBuilder.append(args[2]);
        for(int i = stringBuilder.length(); i < 46; i++)
            stringBuilder.append(" ");
        stringBuilder.append(args[3]);
        for(int i = stringBuilder.length(); i < 50; i++)
            stringBuilder.append(" ");

        String result = "\n" + stringBuilder.toString() + "\n";

        byte[] buffer = result.getBytes();

        FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
        fileOutputStream.write(buffer);
        fileOutputStream.close();

    }
}
