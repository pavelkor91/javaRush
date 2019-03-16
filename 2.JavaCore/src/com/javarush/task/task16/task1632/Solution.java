package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new ThreadOne());
        threads.add(new ThreadTwo());
        threads.add(new ThreadTree());
        threads.add(new ThreadFour());
        threads.add(new ThreadFive());
    }
    public static void main(String[] args) {
    }

    public static class ThreadOne extends Thread{
        @Override
        public void run() {
            while (true){

            }
        }
    }

    public static class ThreadTwo extends Thread{
        @Override
        public void run() {
           if(isInterrupted())
               System.out.println("InterruptedException");
        }
    }

    public static class ThreadTree extends Thread{
        @Override
        public void run() {
            while (true)
            {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
                catch (InterruptedException e){

                }

            }
        }
    }

    public static class ThreadFour extends Thread implements Message{

        @Override
        public void run() {
            while (!isInterrupted()){

            }
        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }

    public static class ThreadFive extends Thread {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> digits = new ArrayList<>();
        @Override
        public void run(){
            String string;
            try {
                while (!(string = bufferedReader.readLine()).equals("N")){
                    digits.add(Integer.parseInt(string));
                }
            }
            catch (IOException e){
                System.out.println(e);
            }
            printSum();
        }
        public void printSum(){
            Integer result = 0;
            for(Integer number: digits)
                result += number;
            System.out.println(result);
        }
    }
}