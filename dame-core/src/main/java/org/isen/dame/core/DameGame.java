package org.isen.dame.core;

import java.util.HashMap;

/**
 * Created by Sandrine on 09/01/2017.
 */
public interface DameGame {

    void play(Piece color, Position init, Position destination);

    String getCell(String column, int row);

    int getColumnsNumber();

    int getRowsNumber();

    Piece getWiner();

}
