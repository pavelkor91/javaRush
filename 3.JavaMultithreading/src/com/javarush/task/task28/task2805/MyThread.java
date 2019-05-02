package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread{
    public static AtomicInteger count = new AtomicInteger(1);

    public MyThread() {
        if (count.get() < 10) setPriority(count.getAndIncrement());
        else {
            setPriority(count.get());
            count.set(1);
        }
    }

    public MyThread(Runnable target) {
        super(target);
        if (count.get() < 10) setPriority(count.getAndIncrement());
        else {
            setPriority(count.get());
            count.set(1);
        }
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if (count.get() < 10) setPriority(count.getAndIncrement());
        else {
            setPriority(count.get());
            count.set(1);
        }
    }

    public MyThread(String name) {
        super(name);
        if (count.get() < 10) setPriority(count.getAndIncrement());
        else {
            setPriority(count.get());
            count.set(1);
        }
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (count.get() < 10) setPriority(count.getAndIncrement());
        else {
            setPriority(count.get());
            count.set(1);
        }
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if (count.get() < 10) setPriority(count.getAndIncrement());
        else {
            setPriority(count.get());
            count.set(1);
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if (count.get() < 10) setPriority(count.getAndIncrement());
        else {
            setPriority(count.get());
            count.set(1);
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if (count.get() < 10) setPriority(count.getAndIncrement());
        else {
            setPriority(count.get());
            count.set(1);
        }
    }
}
