package org.isen.dame.core;

/**
 * Created by Sandrine on 09/01/2017.
 */
public interface DameGame {

    void play(Piece piece, int column, int row, int direction);

    Piece getCell(int column, int row);

    int getColumnsNumber();

    int getRowsNumber();

    Piece getWiner();

}
