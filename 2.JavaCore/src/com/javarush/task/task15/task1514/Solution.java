package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {

        labels.put(3.5,"gd");
        labels.put(3.6,"gd");
        labels.put(3.7,"gd");
        labels.put(3.8,"gd");
        labels.put(3.9,"gd");

    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
