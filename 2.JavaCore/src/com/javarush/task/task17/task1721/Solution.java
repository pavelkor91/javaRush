package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static volatile List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = "";
        String file2 = "";
        try {
            file1 = nameReader.readLine();
            file2 = nameReader.readLine();
        }
        catch (IOException e){}

        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(file1));
        }
        catch (FileNotFoundException e){}

        String s;
        try {
            while ((s = fileReader.readLine()) != null)
                allLines.add(s);

        }
        catch (IOException e){}

        try {
            fileReader = new BufferedReader(new FileReader(file2));

        }
        catch (FileNotFoundException e){}
        try {
            while ((s = fileReader.readLine()) != null)
                forRemoveLines.add(s);
            fileReader.close();
            nameReader.close();
        }
        catch (IOException e){}
        try {
            new Solution().joinData();
        }
        catch (CorruptedDataException e){}


    }

    public  void joinData() throws CorruptedDataException {
            if(allLines.containsAll(forRemoveLines)){
                allLines.removeAll(forRemoveLines);
            }
            else {
                allLines.clear();
                throw new CorruptedDataException();
            }

    }
}
