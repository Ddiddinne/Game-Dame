package org.isen.dame.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sandrine on 09/01/2017.
 */
public class DameGameImpl implements DameGame {
    public static final int COLUMNS_NUMBER = 8;
    private Map<String, String> board = new HashMap<>(COLUMNS_NUMBER);

    public DameGameImpl() {
        initBoard();
    }

    public Map<String, String> initBoard(){

        for (int j=1; j<=COLUMNS_NUMBER/2-1; j++) {
            for(int l=65+(j+1)%2; l<=72; l+=2) {
                String key = Character.toString((char)l) + j;
                board.put(key, Piece.BLACK.toString());
            }
        }

        for (int j=COLUMNS_NUMBER; j>COLUMNS_NUMBER/2+1; j--) {
            for(int l=65+(j+1)%2; l<=72; l+=2) {
                String key = Character.toString((char)l) + j;
                board.put(key, Piece.WHITE.toString());
            }
        }
        return board;
    }

    public void setboard(Map<String, String> board){
        this.board = board;
    }

    @Override
    public void play(Piece color, Position init, Position destination) {


        if(this.board.get(destination.column + destination.row) == null){
            this.board.put(init.column +init.row, null);
            this.board.put(destination.column + destination.row, color.toString());
        }

    }

    @Override
    public String getCell(String column, int row) {
        return this.board.get(column+row);
    }

    @Override
    public int getColumnsNumber() {
        return 0;
    }

    @Override
    public int getRowsNumber() {
        return 0;
    }

    @Override
    public Piece getWiner() {
        return null;
    }
}
