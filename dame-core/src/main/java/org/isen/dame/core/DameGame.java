package org.isen.dame.core;

/**
 * Created by Sandrine on 09/01/2017.
 */
public interface DameGame {

    void play(String column, int row, Direction direction);

    Piece getCell(String column, int row);

    int getColumnsNumber();

    int getRowsNumber();

    Piece getWiner();

}
