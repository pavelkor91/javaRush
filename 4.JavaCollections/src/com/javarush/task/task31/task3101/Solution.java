package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/*
Проход по дереву файлов
*/
public class Solution {

    public static void main(String[] args) {
        File path = new File(args[0]);
        File fileName = new File(args[1]);
        File renamedFile = new File(fileName.getParent() + "/allFilesContent.txt");
        List<File> allFiles = new ArrayList<>();
        getAllFiles(allFiles, path);

        Comparator<File> comparator = ((o1, o2) -> o1.getName().compareTo(o2.getName()));
        Collections.sort(allFiles, comparator);

        if(allFiles.contains(fileName))
            allFiles.remove(fileName);

        for(File file: allFiles){
            System.out.println(file.getAbsoluteFile());
        }

        FileUtils.renameFile(fileName, renamedFile);
        try {
            FileOutputStream writer = new FileOutputStream(renamedFile);

            for(File file: allFiles){
                FileInputStream reader = new FileInputStream(file);
                byte[] bytes = new byte[reader.available()];
                reader.read(bytes);
                writer.write(bytes);
                writer.write("\n".getBytes());
                reader.close();
            }

            writer.close();
        }
        catch (IOException e){
            System.out.println(e);
        }


    }

    public static void getAllFiles(List<File> list, File path){
        for(File file: path.listFiles()){
            if(file.isFile() && file.length() <= 50){
                list.add(file);
            }
            else if (file.isDirectory()){
                getAllFiles(list, file);
            }
        }
    }
}
