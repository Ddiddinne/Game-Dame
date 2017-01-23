package org.isen.dame.core;

import java.util.HashMap;

/**
 * Created by Sandrine on 09/01/2017.
 */
public interface DameGame {

    void play(String column, int row, HashMap<String,Integer> direction);

    Piece getCell(String column, int row);

    int getColumnsNumber();

    int getRowsNumber();

    Piece getWinner();

}
