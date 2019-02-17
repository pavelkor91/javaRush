package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 10; i++)
            list.add(Integer.parseInt(bufferedReader.readLine()));
        int max = 0;
        Integer tmp = 1;
        for (int i = 1; i < list.size(); i++)
        {
            if(list.get(i).equals(list.get(i-1)))
                tmp++;
            else
                if(tmp > max) {
                    max = tmp;
                    tmp = 1;
                }
                else
                    tmp = 1;
        }
        if(tmp > max)
            max = tmp;
        System.out.println(max);
        //напишите тут ваш код

    }
}