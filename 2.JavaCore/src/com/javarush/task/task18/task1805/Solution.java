package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
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
        Set<Integer> treeSet = new TreeSet<>();
        while (fileReader.available() > 0) {
            treeSet.add(fileReader.read());
        }
        fileReader.close();

        for(Integer i: treeSet){
            System.out.print(i + " ");
        }

    }

}
