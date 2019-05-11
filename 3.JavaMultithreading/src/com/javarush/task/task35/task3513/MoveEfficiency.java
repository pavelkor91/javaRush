package com.javarush.task.task35.task3513;

public class MoveEfficiency implements Comparable{
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }


    public int compareTo(MoveEfficiency  o) {
       if(this == o) return 0;
       if(this.numberOfEmptyTiles > o.numberOfEmptyTiles) return  1;
       if(this.numberOfEmptyTiles < o.numberOfEmptyTiles) return  -1;
       if(this.numberOfEmptyTiles == o.numberOfEmptyTiles){
           if(this.score > o.score) return 1;
           if(this.score < o.score) return -1;
       }
       return 0;
    }
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
