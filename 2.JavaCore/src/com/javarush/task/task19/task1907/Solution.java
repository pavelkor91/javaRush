package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        try {
            fileName = bufferedReader.readLine();
            bufferedReader.close();
        }
        catch (IOException e){}

        try {
            FileReader fileReader = new FileReader(fileName);
            int count = 0;
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                String[] wordArray = scanner.nextLine().split("\\p{Punct}|\\s");
                for (String s : wordArray) {
                    if (s.equals("world"))
                        count++;
                }
            }
            System.out.println(count);
            fileReader.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }
}
