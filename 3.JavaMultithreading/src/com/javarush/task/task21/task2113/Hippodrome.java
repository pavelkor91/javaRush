package com.javarush.task.task21.task2113;

import java.io.IOException;
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
        for(Horse horse: horses)
            horse.move();
    }

    public void run() throws InterruptedException{
        for(int i = 0; i < 100; i++){
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void print() {
        for(Horse horse: horses)
            horse.print();

        for(int i = 0; i < 10; i++)
            System.out.println();
        
    }

    public Horse getWinner(){
        Horse winner = horses.get(0);
        for(Horse horse: horses){
            if(winner.getDistance() < horse.getDistance())
                winner = horse;
        }
        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
    public static void main(String[] args) {
        Horse first = new Horse("murka", 3, 0);
        Horse second = new Horse("serbka", 3, 0);
        Horse third = new Horse("durka", 3, 0);
        List<Horse> horses = new ArrayList<>();
        horses.add(first);
        horses.add(second);
        horses.add(third);

        game = new Hippodrome(horses);
        try {
            game.run();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        game.printWinner();
    }
}
