package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("asd");
        list.add("qwrq");
        list.add("asfasad");
        list.add("asf");
        list.add("grg");
        System.out.println(list.size());
        for(String s: list)
            System.out.println(s);
    }
}
