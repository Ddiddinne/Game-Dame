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
            for(int l=65+(j+1)%2; l<=2; l+=2) {
                String key = Character.toString((char)l) + j;
                System.out.println(key);
                board.put(key, Piece.WHITE);
                System.out.println(board);
            }
        }

        for (int j=COLUMNS_NUMBER; j>=COLUMNS_NUMBER/2+1; j--) {
            for(int l=65+(j+1)%2; l<=72; l+=2) {
                String key = Character.toString((char)l) + j;
                System.out.println(key);
                board.put(key, Piece.BLACK);
                System.out.println(board);
            }
        }
        System.out.print(board);
    }

    @Override
    public void play(Piece colour, int column, int row, int direction) {

    }

    @Override
    public Piece getCell(int column, int row) {
        return null;
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
