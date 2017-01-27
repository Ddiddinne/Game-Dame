package org.isen.dame.webapp.service;

import org.apache.commons.lang.RandomStringUtils;
import org.isen.dame.core.Chip;
import org.isen.dame.core.DameGameImpl;
import org.isen.dame.core.Game;
import org.isen.dame.core.Piece;
import org.isen.dame.webapp.DAO.DaoChip;
import org.isen.dame.webapp.DAO.DaoGame;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Sandrine on 26/01/2017.
 */

public class Service {
    private DaoGame daoGame = new DaoGame();
    private DaoChip daoChip = new DaoChip();
    private DameGameImpl dameGameImpl = new DameGameImpl();

    public Game createNewGame(){
        Map<String, Piece> chips = dameGameImpl.initBoard();
        Game game = new Game();
        String token = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
        Piece turn = Piece.WHITE;
        game.setToken(token);
        game.setCurrentTurn(turn);
        daoGame.createGame(token, turn);

        for (Map.Entry<String, Piece> entry : chips.entrySet())
        {
            daoChip.createBoard(token, entry.getKey(), entry.getValue());
        }

        return game;

    }

    public List<Chip> getChips(String token){
        return daoChip.getChips(token);
    }

    public List<Game> testGame(){
        return daoGame.test();
    }

    public List<Chip> testChip(){
        return daoChip.test();
    }
}
