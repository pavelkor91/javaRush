package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);

        Set<String> parts = new TreeSet<>();

        for(int i = 1; i < args.length; i++){
            parts.add(args[i]);
        }

        List<FileInputStream> fileInputStreams = new ArrayList<>();
        for(String part: parts){
            fileInputStreams.add(new FileInputStream(part));
        }

        SequenceInputStream seqInStream = new SequenceInputStream(Collections.enumeration(fileInputStreams));
        ZipInputStream zipInputStream = new ZipInputStream(seqInStream);

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        byte[] buffer = new byte[1024 * 1024];
        while (zipInputStream.getNextEntry() != null){
            int count;
            while ((count = zipInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, count);
            }
        }

        seqInStream.close();
        zipInputStream.close();
        fileOutputStream.close();

    }
}
