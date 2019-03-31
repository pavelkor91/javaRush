package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{
        if(args.length < 2)
            return;

        BufferedReader readFileName = new BufferedReader(new InputStreamReader(System.in));
        String filePath = readFileName.readLine();
        ArrayList<String> arrayList = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(filePath);
        readFileName = new BufferedReader(new InputStreamReader(fileInputStream));

        while (readFileName.ready())
            arrayList.add(readFileName.readLine());

        fileInputStream.close();
        readFileName.close();

        if(args[0].equals("-u")){
            for(int i = 0; i < arrayList.size(); i++){
                int id = Integer.parseInt(arrayList.get(i).substring(0,8).trim());
                if(id == Integer.parseInt(args[1])) {
                    arrayList.set(i, String.format("%-8d%-30s%-8s%-4s", id, args[2], args[3], args[4]));
                }
            }
        }

        if(args[0].equals("-d")){
            for(String s: arrayList){
                int id = Integer.parseInt(s.substring(0,8).trim());
                if(id == Integer.parseInt(args[1]))
                    arrayList.remove(s);
            }
        }

        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        for(String s: arrayList) {
            fileOutputStream.write((s + "\n").getBytes());
        }

        fileOutputStream.close();

    }
}
