package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Map<String, Double> treeMap = new TreeMap<>();

        while (bufferedReader.ready()){
            String[] pair = bufferedReader.readLine().split(" ");

            if(treeMap.containsKey(pair[0])){
                treeMap.put(pair[0], treeMap.get(pair[0]) + Double.parseDouble(pair[1]));
            }
            else
            {
                treeMap.put(pair[0], Double.parseDouble(pair[1]));
            }
        }

        for(Map.Entry entry: treeMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        fileReader.close();

    }
}
