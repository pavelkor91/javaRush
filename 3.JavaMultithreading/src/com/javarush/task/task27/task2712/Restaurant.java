package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet1 = new Tablet(1);
        Cook amigo = new Cook("Amigo");
        Waiter waiter = new Waiter();
        tablet1.addObserver(amigo);
        amigo.addObserver(waiter);
        
        tablet1.createOrder();
        
    }
}
