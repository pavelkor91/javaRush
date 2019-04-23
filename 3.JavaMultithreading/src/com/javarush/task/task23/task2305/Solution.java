package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution first = new Solution();
        Solution seond = new Solution();
        first.innerClasses[0] = first.new InnerClass();
        first.innerClasses[1] = first.new InnerClass();
        seond.innerClasses[0] = seond.new InnerClass();
        seond.innerClasses[1] = seond.new InnerClass();
        Solution[] array = new Solution[2];
        array[0] = first;
        array[1] = seond;

        return array;
    }

    public static void main(String[] args) {

    }
}
