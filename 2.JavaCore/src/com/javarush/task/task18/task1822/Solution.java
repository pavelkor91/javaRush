package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        BufferedReader readFileName = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        List<String> strings = new ArrayList<>();
        try {
            fileName = readFileName.readLine();
            readFileName = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            while (readFileName.ready())
            strings.add(readFileName.readLine());
        }
        catch (IOException e){}

        int id = 0;
        String productName = null;
        double price = 0;
        int quantity = 0;

        for(String s: strings){
            if(s.startsWith(args[0])){
               String[] allParams = s.split(" ");
               id = Integer.parseInt(allParams[0]);
               productName = allParams[1];
               price = Double.parseDouble(allParams[2]);
               quantity = Integer.parseInt(allParams[3]);
            }
        }

        System.out.println(id + " " + productName + " " + price + " " + quantity);
        try {
            readFileName.close();
        }
         catch (IOException e){}
    }
}
