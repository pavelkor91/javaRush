package com.javarush.task.task28.task2807;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* 
Знакомство с ThreadPoolExecutor
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        // Add your code here
        final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        for (int i = 1; i <= 10; i++) {
            final int inc = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    doExpensiveOperation(inc);
                }
            };
            queue.add(runnable);
        }
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(3, 5, 1000, TimeUnit.MILLISECONDS, queue);
        tpe.prestartAllCoreThreads();
        tpe.shutdown();
        tpe.awaitTermination(5, TimeUnit.SECONDS);
        /* Example output
pool-1-thread-2, localId=2
pool-1-thread-3, localId=3
pool-1-thread-1, localId=1
pool-1-thread-3, localId=5
pool-1-thread-2, localId=4
pool-1-thread-3, localId=7
pool-1-thread-1, localId=6
pool-1-thread-3, localId=9
pool-1-thread-2, localId=8
pool-1-thread-1, localId=10
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}
