package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = null;
        String secondFile = null;
        try {
            firstFile = bufferedReader.readLine();
            secondFile = bufferedReader.readLine();
            bufferedReader.close();
        }
        catch (IOException e){};

        List<String> firstFileStrings = new ArrayList<>();
        List<String> secondFileStrings = new ArrayList<>();

        try {
            FileReader fileReader1 = new FileReader(firstFile);
            FileReader fileReader2 = new FileReader(secondFile);
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            while (bufferedReader1.ready()){
                firstFileStrings.add(bufferedReader1.readLine());
            }
            while (bufferedReader2.ready()){
                secondFileStrings.add(bufferedReader2.readLine());
            }
            fileReader1.close();
            fileReader2.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}

        while (!firstFileStrings.isEmpty() || !secondFileStrings.isEmpty()){
            if(!firstFileStrings.isEmpty() && firstFileStrings.get(0).equals(secondFileStrings.get(0))){
                lines.add(new LineItem(Type.SAME, firstFileStrings.get(0)));
                firstFileStrings.remove(0);
                firstFileStrings.remove(0);
            }
            else if(!firstFileStrings.isEmpty() && firstFileStrings.get(1).equals(secondFileStrings.get(0))){
                lines.add(new LineItem(Type.REMOVED, firstFileStrings.get(0)));
                firstFileStrings.remove(0);
            }
            else if(!firstFileStrings.isEmpty() && firstFileStrings.get(0).equals(secondFileStrings.get(1))){
                lines.add(new LineItem(Type.ADDED, secondFileStrings.get(0)));
                secondFileStrings.remove(0);
            }
        }

        for(LineItem item: lines){
            StringBuilder sb = new StringBuilder();
            sb.append(item.line);
            sb.append(" ");
            switch (item.type){
                case SAME:sb.append("SAME"); break;
                case ADDED:sb.append("ADDED"); break;
                case REMOVED:sb.append("REMOVED"); break;
            }
            System.out.println(sb.toString());
        }



    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
