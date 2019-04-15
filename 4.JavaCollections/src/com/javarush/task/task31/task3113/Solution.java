package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {
    private static int allDirectorys = 0;
    private static int allFiles = 0;
    private static long allSize = 0L;

    public static void main(String[] args) throws IOException {
        final Solution solution = new Solution();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = bufferedReader.readLine();
        bufferedReader.close();

        Path path = Paths.get(filePath);
        if(!Files.isDirectory(path)){
            System.out.println(path + " - не папка");
            return;
        }
        Files.walkFileTree(path, solution);

        System.out.println("Всего папок - " + getAllDirectorys());
        System.out.println("Всего файлов - " + getAllFiles());
        System.out.println("Общий размер - " + getAllSize());
    }

    public static int getAllDirectorys() {
        return allDirectorys - 1;
    }

    public static int getAllFiles() {
        return allFiles;
    }

    public static long getAllSize() {
        return allSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(attrs.isRegularFile())
            allFiles++;

        allSize += attrs.size();

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        allDirectorys++;
        return FileVisitResult.CONTINUE;
    }
}
