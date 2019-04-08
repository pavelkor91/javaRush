package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuilder sb = new StringBuilder();
        while (bufferedReader.ready()){
            String[] dataArr = bufferedReader.readLine().split(" ");
            for(String s: dataArr){
                if(s.length() > 6){
                    sb.append(s).append(",");
                }
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        fileWriter.write(sb.toString());

        fileReader.close();
        fileWriter.close();
    }
}
