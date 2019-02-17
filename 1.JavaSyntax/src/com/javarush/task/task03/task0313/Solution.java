package com.javarush.task.task03.task0313;

/* 
Мама мыла раму
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] txt = new String[]{"Мама", "Мыла", "Раму"};
        mix(txt,txt.length);

    }
    private static void mix(String[] arr,  int size){
        if(size < 2) {
            for (String s : arr)
                System.out.print(s);
            System.out.println("");
        }
        else
            for(int i = 0; i < size; i++){
                swap(arr, i, size - 1);
                mix(arr, size - 1);
                swap(arr,size - 1, i);
            }
    }
    private static void swap(String[] arr, int k, int i){
        String tmp = arr[k];
        arr[k] = arr[i];
        arr[i] = tmp;
    }
}

