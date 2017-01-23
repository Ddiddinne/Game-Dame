package org.isen.dame.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sandrine on 09/01/2017.
 */
public class DameGameImpl implements DameGame {
    public static final int COLUMNS_NUMBER = 8;
    Map<String, Piece> board = new HashMap<>(COLUMNS_NUMBER);

    public DameGameImpl() {
        initBoard();
    }

    private void initBoard(){

        for (int j=1; j<=COLUMNS_NUMBER/2-1; j++) {
            for(int l=65+(j+1)%2; l<=72; l+=2) {
                String key = Character.toString((char)l) + j;
                board.put(key, Piece.WHITE);
            }
        }

        for (int j=COLUMNS_NUMBER; j>COLUMNS_NUMBER/2+1; j--) {
            for(int l=65+(j+1)%2; l<=72; l+=2) {
                String key = Character.toString((char)l) + j;
                board.put(key, Piece.BROWN);
            }
        }
    }

    @Override
    public void play(String column, int row, HashMap<String,Integer> direction) {

        Piece piece = this.board.get(column+row);

        int ascii = column.charAt(0);
        ascii+=direction.get("x");
        int rowf = row + direction.get("y");
        String columnf = Character.toString((char) ascii);
        if(this.board.get(columnf + rowf) == null){
            this.board.put(column + row, null);
            this.board.put(columnf + rowf, piece);
        }

    }

    @Override
    public Piece getCell(String column, int row) {
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
    public Piece getWinner() {
        return null;
    }
}
