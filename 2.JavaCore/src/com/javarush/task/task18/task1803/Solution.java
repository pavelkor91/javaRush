package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = null;
        try {
            filePath = bufferedReader.readLine();
        }
        catch (IOException e){}
        bufferedReader.close();

        FileInputStream fileReader = new FileInputStream(filePath);
        Map<Integer, Integer> charMap = new HashMap<>();
        while (fileReader.available() > 0){
            Integer tmp = fileReader.read();
            if(charMap.containsKey(tmp)){
                charMap.put(tmp,charMap.get(tmp) + 1);
            }
            else {
                charMap.put(tmp, 1);
            }
        }
        fileReader.close();
        Integer maxValue = 0;
        for(Map.Entry entry: charMap.entrySet()){
            if((Integer)entry.getValue() > maxValue)
            {
                maxValue = (Integer) entry.getValue();
            }
        }
        for(Map.Entry entry: charMap.entrySet()){
            if(entry.getValue().equals(maxValue)){
                System.out.print (entry.getKey() + " ");
            }
        }
    }
}
