package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hashMap = new HashMap<>();


        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            Integer id = Integer.parseInt(s);
            String name = reader.readLine();
            hashMap.put(name, id);
        }

        for(Map.Entry<String, Integer> entry: hashMap.entrySet())
        System.out.println(entry.getValue() + "  " + entry.getKey());
    }
}
