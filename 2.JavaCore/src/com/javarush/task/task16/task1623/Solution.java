package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread{
        @Override
        public String toString() {
            return getName() + " created";
        }

        public GenerateThread(){
            super(Integer.toString(++createdThreadCount));
           // Solution.createdThreadCount++;
            this.start();

        }

        @Override
        public void run() {
            if(Solution.createdThreadCount < Solution.count){
                System.out.println(new GenerateThread());
            }
        }
    }
}
