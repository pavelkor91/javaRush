package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;
    @Override
    public void run() {
        try {
            while (!thread.currentThread().isInterrupted()) {

                thread.sleep(0);
                System.out.println(thread.getName());
                thread.sleep(90);
            }
        }
        catch (InterruptedException e) { }
    }

    @Override
    public void start(String threadName) {
        thread = new Thread(this);
        thread.setName(threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
