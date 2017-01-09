package org.isen.dame.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sandrine on 09/01/2017.
 */
public class DameGameImpl implements DameGame {
    public static final int COLUMNS_NUMBER = 10;
    List<List<Piece>> board = new ArrayList<>(COLUMNS_NUMBER);

    public DameGameImpl() {
        initBoard();
    }

    private void initBoard(){
        for (int i=0; i< COLUMNS_NUMBER; i++ ) {
            board.add(new ArrayList<Piece>(COLUMNS_NUMBER));
        }
    }

    @Override
    public void play(Piece colour, int column, int row) {

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
