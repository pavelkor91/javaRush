package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Map<Character, Integer> allSymb = new TreeMap<>();
        byte[] data = null;
        try {
            FileInputStream fileReader = new FileInputStream(args[0]);
            data = new byte[fileReader.available()];
            fileReader.read(data);
            fileReader.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}
        String text = new String(data);
        for(Character c: text.toCharArray()){
            if(allSymb.containsKey(c)){
                allSymb.put(c, allSymb.get(c) + 1);
            }
            else
            {
                allSymb.put(c, 1);
            }
        }

        for(Map.Entry<Character, Integer> entry: allSymb.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
