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
        Map<String, String> chips = dameGameImpl.initBoard();
        Game game = new Game();
        String token = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
        Piece turn = Piece.WHITE;
        game.setToken(token);
        game.setCurrentTurn(turn);
        daoGame.createGame(token, turn);

        for (Map.Entry<String, String> entry : chips.entrySet())
        {
            daoChip.createBoard(token, entry.getKey(), entry.getValue());
        }

        return game;

    }

    public List<Chip> getChips(String token){
        return daoChip.getChips(token);
    }

    public List<Chip> play(String token, String caseinit, String casefinal){
        List<Chip> listChip = daoChip.getChips(token);

        boolean here = true;

        Character columnInit = caseinit.charAt(0);
        Character rowInit = caseinit.charAt(1);

        Character columnFinal = casefinal.charAt(0);
        Character rowFinal = casefinal.charAt(1);

        if(Math.abs(columnInit-columnFinal)==Math.abs(rowInit-rowFinal) && Math.abs(columnInit-columnFinal)==1) {
            for (int i = 0; i < listChip.size(); i++) {
                Chip chip = listChip.get(i);
                if (chip.getPosition().equals(casefinal)) {
                    here = false;
                }
            }
            if (here) {
                for (int j = 0; j < listChip.size(); j++) {
                    Chip chip = listChip.get(j);
                    if (chip.getPosition().equals(caseinit)) {
                        chip.setPosition(casefinal);
                        daoChip.updateChip(token, caseinit, casefinal);
                    }
                }
            }
        }else if(Math.abs(columnInit-columnFinal)==Math.abs(rowInit-rowFinal) && Math.abs(columnInit-columnFinal)==2) {
            Character columnInter = (char)((columnInit+columnFinal)/2);
            Character rowInter = (char)((rowInit+rowFinal)/2);
            String positionInter = columnInter.toString() + rowInter;
            here = false;
            for (int i = 0; i < listChip.size(); i++) {
                Chip chip = listChip.get(i);
                if (chip.getPosition().equals(positionInter)) {
                    here = true;
                }
            }
            if(here){
                for (int j = 0; j < listChip.size(); j++) {
                    Chip chip = listChip.get(j);
                    if (chip.getPosition().equals(caseinit)) {
                        chip.setPosition(casefinal);
                        daoChip.updateChip(token, caseinit, casefinal);
                    }
                }
            }
        }

        return listChip;

    }

    public List<Game> testGame(){
        return daoGame.test();
    }

    public List<Chip> testChip(){
        return daoChip.test();
    }
}
