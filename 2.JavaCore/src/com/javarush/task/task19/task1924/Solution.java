package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");

    }
    public static void main(String[] args) throws IOException {

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = consoleReader.readLine();
        consoleReader.close();

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedFileReader = new BufferedReader(fileReader);

        while (bufferedFileReader.ready()){
            String[] dataArr = bufferedFileReader.readLine().split(" ");
            StringBuilder result = new StringBuilder();
            for(String s: dataArr){
                for(Map.Entry entry: map.entrySet()){
                    if(entry.getKey().toString().equals(s)){
                        s = entry.getValue().toString();
                    }
                }
                result.append(s).append(" ");
            }
            System.out.println(result.toString().trim());
        }
        fileReader.close();
    }
}
