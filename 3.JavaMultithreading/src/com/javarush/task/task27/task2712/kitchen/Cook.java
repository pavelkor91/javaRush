package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private final String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Order tmp = (Order) arg;
        ConsoleHelper.writeMessage("Start cooking - "+ arg + ", cooking time " + tmp.getTotalCookingTime() +"min");
        setChanged();
        notifyObservers(arg);
    }

    @Override
    public String toString() {
        return name;
    }
}
