package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream(Statics.FILE_NAME));
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        while (scanner.hasNext())
        lines.add(scanner.nextLine());

    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
