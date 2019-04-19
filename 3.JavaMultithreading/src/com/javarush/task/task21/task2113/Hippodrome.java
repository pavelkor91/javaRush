package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move(){

    }

    public void run(){

    }

    public void print(){

    }
    public static void main(String[] args) {
        Horse first = new Horse("murka", 3, 0);
        Horse second = new Horse("murka", 3, 0);
        Horse third = new Horse("murka", 3, 0);
        List<Horse> horses = new ArrayList<>();
        horses.add(first);
        horses.add(second);
        horses.add(third);

        game = new Hippodrome(horses);
    }
}
