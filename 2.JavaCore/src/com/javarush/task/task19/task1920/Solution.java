package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

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

        Double max = 0.0;
        Set<String> set = new TreeSet<>();
        for(Map.Entry entry: treeMap.entrySet()){
            if((Double) entry.getValue() >= max)
                set.add(entry.getKey().toString());
        }
        for(String s: set)
            System.out.println(s);
        fileReader.close();

    }
}
