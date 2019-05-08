package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    protected static int score = 0;
    protected static int maxTile = 0;


    public Model(){
        this.score = 0;
        this.maxTile = 0;
        resetGameTiles();
    }

    private List<Tile> getEmptyTiles(){
        List<Tile> list = new ArrayList<>();
        for(int i = 0; i < FIELD_WIDTH; i++){
            for(int j = 0; j < FIELD_WIDTH; j++){
                if(gameTiles[i][j].value == 0){
                    list.add(gameTiles[i][j]);
                }
            }
        }
        return list;
    }

    private void addTile(){
        List<Tile> list = getEmptyTiles();
        if (list != null && list.size() != 0) {
            list.get((int) (list.size() * Math.random() )).setValue(Math.random() < 0.9 ? 2 : 4);
        }
    }

    protected void resetGameTiles(){
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for(int i = 0; i< FIELD_WIDTH ; i++){
            for (int j = i; j < FIELD_WIDTH ; j++){
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private static void compressTiles(Tile[] tiles){
       for(int i = 0; i < tiles.length - 1; i++){
           if(tiles[i].value == 0){
               for(int j = i; j < tiles.length - 1; j++){
                   tiles[j].value = tiles[j + 1].value;
               }
               tiles[tiles.length - 1].value = 0;
           }
       }
    }
    private static void mergeTiles(Tile[] tiles){
        for(int i = 0; i < tiles.length - 1; i++){
            if(tiles[i].value == tiles[i + 1].value){
                tiles[i].value = tiles[i].value * 2;
                if(tiles[i].value > maxTile)
                    maxTile = tiles[i].value;
                score = score + tiles[i].value;
                tiles[i + 1].value = 0;
                i++;
            }
        }
        compressTiles(tiles);
    }

    public static void main(String[] args) {
        Tile[] testTiles = new Tile[]{
            new Tile(0),
            new Tile(0),
            new Tile(4),
            new Tile(4)
        };
        compressTiles(testTiles);
        //mergeTiles(testTiles);
        for (Tile tile : testTiles) {
            System.out.println(tile.getValue());
        }
        System.out.println();
        System.out.println(score);
        System.out.println(maxTile);
    }
}
