package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    private int score;
    private int maxTile;


    public Model(){
        resetGameTiles();
        score = 0;
        maxTile = 0;
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
            for (int j = 0; j < FIELD_WIDTH ; j++){
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }


}
