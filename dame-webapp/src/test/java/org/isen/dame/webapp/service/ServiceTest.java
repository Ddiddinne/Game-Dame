package org.isen.dame.webapp.service;

import org.isen.dame.core.*;
import org.isen.dame.webapp.DAO.DaoChip;
import org.isen.dame.webapp.DAO.DaoGame;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Sandrine on 16/02/2017.
 */

public class ServiceTest {

    private static DaoGame daoGame = mock(DaoGame.class);
    private static DaoChip daoChip = mock(DaoChip.class);
    private static DameGameImpl dameGameimpl = new DameGameImpl();
    private Service service = new Service(daoGame, daoChip, dameGameimpl);

    private static Game game;
    private static List<Game> list;
    private Game game2;
    private static List<Chip> chip;

    @BeforeClass
    public static void setUp(){
        game = Game.builder()
                .token("123456789")
                .currentTurn(Piece.WHITE.toString())
                .build();
        list = new ArrayList<>();
        list.add(game);

        //listChip
        chip=new ArrayList<>();
        Map<String, String> chips = dameGameimpl.initBoard();
        for (Map.Entry<String, String> entry : chips.entrySet())
        {
            Chip chipValue = Chip.builder()
                    .token(game.getToken())
                    .position(entry.getKey())
                    .piece(entry.getValue())
                    .build();
            chip.add(chipValue);
        }
        when(daoGame.test()).thenReturn(list);
        when(daoChip.test()).thenReturn(chip);
        when(daoGame.getTurn(anyString())).thenReturn(game);
        when(daoChip.getChips(anyString())).thenReturn(chip);
        //Mockito.doCallRealMethod().when(daoGame).updateTurn(anyString(),anyString());
    }

    @Test
    public void testGame(){
        List<Game> response = service.testGame();
        assertEquals(response, list);
    }

    @Test
    public void testChips(){
        List<Chip> response = service.testChip();
        assertEquals(response, chip);
    }

    @Test
    public void testTurn(){
        Game response = service.getTurn("123456789");
        assertEquals(response.getCurrentTurn().toString(),"WHITE");
        service.changeTurn("BLACK","123456789");
        response = service.getTurn("123456789");
        //assertEquals(response.getCurrentTurn().toString(),"BLACK");*/
    }

    @Test
    public void testPlay(){
        List<Chip> testChip=service.play("123456789","A7","B8");
        assertEquals(testChip.get(23).getPosition(), "A7");
        testChip=service.play("123456789","A7","A8");
        assertEquals(testChip.get(23).getPosition(), "A7");
        testChip=service.play("123456789","A7","A6");
        assertEquals(testChip.get(23).getPosition(), "A7");
        testChip=service.play("123456789","A7","B6");
        assertEquals(testChip.get(23).getPosition(), "A7");
        testChip=service.play("123456789","A7","B7");
        assertEquals(testChip.get(23).getPosition(), "A7");

        testChip=service.play("123456789","B6","A5");
        assertEquals(testChip.get(21).getPosition(), "A5");
        testChip=service.play("123456789","A3","B4");
        assertEquals(testChip.get(15).getPosition(), "B4");
        testChip=service.play("123456789","A5","C3");
        assertEquals(testChip.get(21).getPosition(), "A5");

        testChip=service.play("123456789","D6","E5");
        assertEquals(testChip.get(18).getPosition(), "E5");
        testChip=service.play("123456789","C3","D4");
        assertEquals(testChip.get(11).getPosition(), "D4");
        testChip=service.play("123456789","A5","C3");
        assertEquals(testChip.get(20).getPosition(), "C3");
    }



}
