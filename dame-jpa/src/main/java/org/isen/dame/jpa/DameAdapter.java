package org.isen.dame.jpa;


import org.isen.dame.core.DameGame;
import org.isen.dame.core.DameGameImpl;
import org.isen.dame.core.Piece;

import java.util.HashMap;

/**
 * Created by Sandrine on 23/01/2017.
 */
public class DameAdapter implements DameGame {

    private DameGame coreGame;

    private DameDao dao;
    private Game game;

    public DameAdapter(DameDao dao, Game game) {
        this.dao = dao;
        this.game = game;
        this.coreGame = new DameGameImpl();

    }

    @Override
    public void play(String column, int row, HashMap<String, Integer> direction) {
        coreGame.play(column, row, direction);
    }

    @Override
    public Piece getCell(String column, int row) {
        return coreGame.getCell(column, row);
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

    public String getToken() {
        return game.getToken();
    }
}
