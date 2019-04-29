package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {

        if(lock.tryLock() == false){
            actionIfLockIsBusy();
        }
        else {
            try {
                actionIfLockIsFree();
            }
            finally {
                lock.unlock();
            }
        }

    }


    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }
}
