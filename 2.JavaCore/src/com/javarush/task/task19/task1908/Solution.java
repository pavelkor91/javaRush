package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = null;
        String secondFile = null;

        try {

            firstFile = bufferedReader.readLine();
            secondFile = bufferedReader.readLine();
            bufferedReader.close();
        }
        catch (IOException e){}

        try {
            FileReader fileReader = new FileReader(firstFile);
            bufferedReader = new BufferedReader(fileReader);
            List<Integer> list = new ArrayList<>();
            while (bufferedReader.ready()){
                String[] allStrings = bufferedReader.readLine().split("\\b[^0-9]+\\b");
                for(String s:allStrings){
                    try {
                        list.add(Integer.parseInt(s));
                    }
                    catch (NumberFormatException e){continue;}
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i: list)
                sb.append(i + " ");
            String result = sb.toString().trim();

            bufferedReader.close();
            FileWriter fileWriter = new FileWriter(secondFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(result);
            bufferedWriter.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }
}
