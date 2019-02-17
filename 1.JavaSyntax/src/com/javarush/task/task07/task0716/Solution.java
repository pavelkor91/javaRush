package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); // 0
        list.add("лоза"); // 1
        list.add("лира"); // 2
        list.add("вода");
        list.add("мера");
        list.add("упор");
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++){

            if(list.get(i).contains("р") && list.get(i).contains("л") == false){
                list.remove(i);
                i--;
            }
        }
        int size = list.size();
        for (int i = 0; i < size; i++){
            if(list.get(i).contains("л") && list.get(i).contains("р"))
                continue;
            if(list.get(i).contains("л") && list.get(i).contains("р") == false){
                list.add(list.get(i));
            }
        }
        return list;
    }
}