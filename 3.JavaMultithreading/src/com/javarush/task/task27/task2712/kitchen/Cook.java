package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

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
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(tmp.getTablet().toString(), this.name, tmp.getTotalCookingTime(), tmp.getDishes()));
        setChanged();
        notifyObservers(arg);
    }

    @Override
    public String toString() {
        return name;
    }
}
