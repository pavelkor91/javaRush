package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/


import javax.swing.tree.TreeNode;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path = null;

        try {
            path = bufferedReader.readLine();
        }
        catch (IOException e){
            System.out.println("Error");
        }

        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

        TreeSet<Integer> treeSet = new TreeSet<>();

        do{
            Integer tmp = Integer.parseInt(bufferedReader1.readLine());
            if (tmp != null) {
                if (tmp % 2 == 0) {
                    treeSet.add(tmp);
                }
            }
            else
                break;
        }
        while(true);

        bufferedReader.close();
        bufferedReader1.close();
    }
}
