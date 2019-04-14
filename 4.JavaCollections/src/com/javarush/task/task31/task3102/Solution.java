package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> allFiles = new ArrayList<>();
        File path = new File(root);
        Queue<File> queue = new ArrayDeque<>();
        queue.add(path);
        while (queue.peek() != null){
            for(File file: ((ArrayDeque<File>) queue).pop().listFiles()){
                if(file.isDirectory())
                    ((ArrayDeque<File>) queue).addFirst(file);
                else
                    allFiles.add(file.getAbsolutePath());
            }
        }
        return allFiles;

    }

    public static void main(String[] args) throws IOException{
         List<String> allFiles = getFileTree("D:\\programming\\java\\JavaRushTasks\\resources\\");
         for(String file: allFiles){
             System.out.println(file);
         }
    }
}
