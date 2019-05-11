package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int maxTile = 0;
    int score = 0;
    private Stack<Tile[][]> previousStates = new Stack();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;


    public Model(){
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        resetGameTiles();
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTileList = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0) {
                    emptyTileList.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTileList;
    }

    private void addTile() {
        List<Tile> listForChanges = getEmptyTiles();
        if (listForChanges != null && listForChanges.size() != 0) {
            listForChanges.get((int) (listForChanges.size() * Math.random())).value =
                    (Math.random() < 0.9 ? 2 : 4);
        }
    }

    public void resetGameTiles() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        this.maxTile = 0;
        this.score = 0;
        addTile();
        addTile();
    }


    private boolean mergeTiles(Tile[] tiles) {
        boolean changes = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value != 0 && (tiles[i].value == tiles[i + 1].value)) {
                if (tiles[i].value + tiles[i + 1].value > maxTile) {
                    maxTile = tiles[i].value + tiles[i + 1].value;
                }
                tiles[i].value = tiles[i].value + tiles[i + 1].value;
                score += tiles[i].value;
                tiles[i + 1].value = 0;
                changes = true;
                compressTiles(tiles);
            }
        }
        return changes;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean changes = false;
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].value == 0 && i < tiles.length - 1 && tiles[i + 1].value != 0) {
                Tile temp = tiles[i];
                tiles[i] = tiles[i + 1];
                tiles[i + 1] = temp;
                i = -1;
                changes = true;
            }
        }
        return changes;
    }

    public void left() {
        if(isSaveNeeded)
        saveState(this.gameTiles);
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                addTile();
            }
        }
        isSaveNeeded = true;
    }

    public void rotate() {
        for (int k = 0; k < 2; k++) {
            for (int j = k; j < 3 - k; j++) {
                Tile alternative = gameTiles[k][j];
                gameTiles[k][j] = gameTiles[j][3 - k];
                gameTiles[j][3 - k] = gameTiles[3 - k][3 - j];
                gameTiles[3 - k][3 - j] = gameTiles[3 - j][k];
                gameTiles[3 - j][k] = alternative;
            }
        }
    }


    public void up() {
        saveState(gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    public void down() {
        saveState(gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    public void right() {
        saveState(gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public void randomMove(){
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n){
            case 1: left(); break;
            case 2: right(); break;
            case 3: up(); break;
            case 4: down(); break;
        }
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }
    public boolean canMove(){
            if (!getEmptyTiles().isEmpty()) {
                return true;
            }
            for (int i = 0; i < gameTiles.length; i++) {
                for (int j = 0; j < gameTiles.length - 1; j++) {
                    if (gameTiles[i][j].value == gameTiles[i][j + 1].value) {
                        return true;
                    }
                }
            }
            for (int j = 0; j < gameTiles.length; j++) {
                for (int i = 0; i < gameTiles.length - 1; i++) {
                    if (gameTiles[i][j].value == gameTiles[i + 1][j].value) {
                        return true;
                    }
                }
            }
            return false;
        }

        private void saveState(Tile[][] game){
            Tile[][] newArray = new Tile[FIELD_WIDTH][FIELD_WIDTH];
            for(int i = 0; i < FIELD_WIDTH; i++){
                for(int j = 0; j < FIELD_WIDTH; j++){
                    newArray[i][j] = new Tile(game[i][j].value);
                }
            }
            previousStates.push(newArray);
            previousScores.push(score);
            isSaveNeeded = false;
        }
        public void rollback(){
            if(previousStates.size() > 0 && previousScores.size() > 0){
                gameTiles = previousStates.pop();
                score = previousScores.pop();
            }
        }
        public boolean hasBoardChanged(){
            int currentResult = 0;
            int prevResult = 0;
                for(int i = 0; i < FIELD_WIDTH; i++){
                    for(int j = 0; j < FIELD_WIDTH; j++){
                        currentResult += gameTiles[i][j].value;
                        prevResult += previousStates.peek()[i][j].value;
                    }
                }
                return currentResult == prevResult ? false : true;
        }

        public MoveEfficiency getMoveEfficiency(Move move){
            MoveEfficiency moveEfficiency;
            move.move();
            if (hasBoardChanged()) moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
            else moveEfficiency = new MoveEfficiency(-1, 0, move);
            rollback();

            return moveEfficiency;
        }

        public void autoMove(){
            PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());
            priorityQueue.offer(getMoveEfficiency(() -> left()));
            priorityQueue.offer(getMoveEfficiency(() -> right()));
            priorityQueue.offer(getMoveEfficiency(() -> up()));
            priorityQueue.offer(getMoveEfficiency(() -> down()));

            priorityQueue.peek().getMove().move();
        }


    

    //    public static void main(String[] args) {
//        Tile[] testTiles = new Tile[]{
//            new Tile(0),
//            new Tile(0),
//            new Tile(4),
//            new Tile(0)
//        };
//       // compressTiles(testTiles);
//       // mergeTiles(testTiles);
//        for (Tile tile : testTiles) {
//            System.out.println(tile.getValue());
//        }
//        System.out.println();
//       // System.out.println(score);
//       // System.out.println(maxTile);
//    }
}
