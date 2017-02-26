package org.isen.dame.webapp.service;

import org.apache.commons.lang.RandomStringUtils;
import org.isen.dame.core.Chip;
import org.isen.dame.core.DameGameImpl;
import org.isen.dame.core.Game;
import org.isen.dame.core.Piece;
import org.isen.dame.webapp.DAO.DaoChip;
import org.isen.dame.webapp.DAO.DaoGame;

import com.google.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created by Sandrine on 26/01/2017.
 */

public class Service {
    private DaoGame daoGame;
    private DaoChip daoChip;
    private DameGameImpl dameGameImpl;

    @Inject
    public Service(DaoGame daoGame, DaoChip daoChip, DameGameImpl dameGameImpl){
        this.daoGame = daoGame;
        this.daoChip = daoChip;
        this.dameGameImpl = dameGameImpl;
    }


    public Game createNewGame(){
        Map<String, String> chips = dameGameImpl.initBoard();
        Game game = new Game();
        String token = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
        Piece turn = Piece.WHITE;
        game.setToken(token);
        game.setCurrentTurn(turn.toString());
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
        boolean isPiece=false;
        Character columnInit = caseinit.charAt(0);
        Character rowInit = caseinit.charAt(1);

        Character columnFinal = casefinal.charAt(0);
        Character rowFinal = casefinal.charAt(1);
        String color="";
        for (int i = 0; i < listChip.size(); i++) {

            Chip chip = listChip.get(i);
            if (chip.getPosition().equals(caseinit)) {
                color = chip.getPiece();
            }
            if (chip.getPosition().equals(casefinal)) {
                isPiece = true;
            }
        }
        if(!isPiece){
            if(Math.abs(columnInit-columnFinal)==Math.abs(rowInit-rowFinal) && Math.abs(columnInit-columnFinal)==1) {

                for (int i = 0; i < listChip.size(); i++) {

                    Chip chip = listChip.get(i);

                    if (chip.getPosition().equals(casefinal)) {
                        here = false;
                    }
                }
                if (here && ((color.equals("WHITE") && rowFinal-rowInit<0)||(color.equals("BLACK") && rowFinal-rowInit>0))) {
                    for (int j = 0; j < listChip.size(); j++) {
                        Chip chip = listChip.get(j);
                        if (chip.getPosition().equals(caseinit)) {
                            chip.setPosition(casefinal);
                            daoChip.updateChip(token, caseinit, casefinal);
                        }
                    }
                    changeTurn(color, token);
                }
            }else if(Math.abs(columnInit-columnFinal)==Math.abs(rowInit-rowFinal) && Math.abs(columnInit-columnFinal)==2) {
                Character columnInter = (char)((columnInit+columnFinal)/2);
                Character rowInter = (char)((rowInit+rowFinal)/2);
                String positionInter = columnInter.toString() + rowInter;
                here = false;
                List<Chip> listCopy = listChip;
                for (int i = 0; i < listCopy.size(); i++) {
                    Chip chip = listCopy.get(i);
                    if (chip.getPosition().equals(positionInter) && chip.getPiece()!=color) {
                        here = true;
                        daoChip.removeChip(token, positionInter);
                        listChip.remove(i);
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
                    changeTurn(color, token);
                }
            }
        }
        return listChip;

    }

    public void changeTurn(String turn, String token){
        if(turn=="WHITE"){
            daoGame.updateTurn("BLACK", token);
        }else{
            daoGame.updateTurn("WHITE", token);
        }
    }

    public List<Game> testGame(){
        return daoGame.test();
    }

    public List<Chip> testChip(){
        return daoChip.test();
    }

    public Game getTurn(String token){ return daoGame.getTurn(token);}

    public void removeGame(String token){
        daoChip.removeGame(token);
        daoGame.removeGame(token);
    }
}
