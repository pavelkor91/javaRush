package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++)
            arrayList.add(Integer.parseInt(bufferedReader.readLine()));
        ArrayList<Integer> divide3 = new ArrayList<Integer>();
        ArrayList<Integer> divide2 = new ArrayList<Integer>();
        ArrayList<Integer> others = new ArrayList<Integer>();
        for(Integer i: arrayList) {
            if (i % 2 == 0)
                divide2.add(i);
            if (i % 3 == 0)
                divide3.add(i);
            if (i % 3 != 0 && i % 2 != 0)
                others.add(i);

        }
            printList(divide3);
            printList(divide2);
            printList(others);

    }

    public static void printList(List<Integer> list) {
        for(Integer i: list)
            System.out.println(i);
        //напишите тут ваш код
    }
}
