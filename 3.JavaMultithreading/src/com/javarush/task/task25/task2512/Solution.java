package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        t.interrupt();
        List<Throwable> throwables = new ArrayList<>();
        Throwable throwable = e;
        while (throwable != null) {
            throwables.add(0, throwable);
            throwable = throwable.getCause();
        }
        for(Throwable th: throwables){
            System.out.println(th);
        }
     }

    public static void main(String[] args) {
        Throwable e =  new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        new Solution().uncaughtException(Thread.currentThread(), e);


    }
}
