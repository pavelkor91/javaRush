package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/


import javax.swing.tree.TreeNode;
import java.io.*;
import java.util.*;

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
        Scanner scanner = new Scanner(bufferedReader1);
        ArrayList<Integer> arrayList= new ArrayList<>();

       while (scanner.hasNextLine()){
           int tmp = Integer.parseInt(scanner.nextLine());
           if (tmp % 2 == 0){
               arrayList.add(tmp);
           }
       }
       Collections.sort(arrayList);
       for(Integer i: arrayList){
           System.out.println(i);
       }

        bufferedReader.close();
        bufferedReader1.close();
    }
}
