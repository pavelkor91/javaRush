package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        final float medium;
        if (array.length % 2 == 0)
            medium = (array[array.length / 2 - 1] + array[array.length / 2]) / 2f;
        else
            medium = array[array.length / 2];
        Arrays.sort(array, new Comparator<Integer>()
        {

            @Override
            public int compare(Integer o1, Integer o2)
            {
                int result = (int) (Math.abs(o1 - medium) - Math.abs(o2 - medium));
                return result == 0 ? o1 - o2 : result;
            }
        });
        return array;
    }
}
