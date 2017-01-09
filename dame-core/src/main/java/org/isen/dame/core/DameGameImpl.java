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

        for (int j=COLUMNS_NUMBER; j>=COLUMNS_NUMBER/2+1; j--) {
            for(int l=65+(j+1)%2; l<=72; l+=2) {
                String key = Character.toString((char)l) + j;
                board.put(key, Piece.BLACK);
            }
        }
    }

    @Override
    public void play(String column, int row, Direction direction) {

        Piece piece = this.board.get(column+row);
        this.board.put(column + row, null);
        int ascii = column.charAt(0);

        if (piece == Piece.WHITE) {
            row++;
            if (direction == Direction.RIGHT) {
                ascii++;

            } else {
                ascii--;
            }
            column = Character.toString((char) ascii);
            this.board.put(column + row, piece);
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
    public Piece getWiner() {
        return null;
    }
}
