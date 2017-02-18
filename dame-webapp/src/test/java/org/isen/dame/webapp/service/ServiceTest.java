package org.isen.dame.webapp.service;

import org.isen.dame.core.*;
import org.isen.dame.webapp.DAO.DaoChip;
import org.isen.dame.webapp.DAO.DaoGame;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Sandrine on 16/02/2017.
 */

public class ServiceTest {

    private DaoGame daoGame = mock(DaoGame.class);
    private DaoChip daoChip = mock(DaoChip.class);
    private DameGameImpl dameGameimpl = new DameGameImpl();
    private Service service = new Service(daoGame, daoChip, dameGameimpl);

    private Game game;
    private List<Game> list;
    private Game game2;
    private List<Chip> chip;

    @Before
    public void setUp(){
        game = new Game();
        game.setToken("123456789");
        game.setCurrentTurn(Piece.WHITE);
        list = new ArrayList<>();
        list.add(game);

        //listChip
        chip=new ArrayList<>();
        Map<String, String> chips = dameGameimpl.initBoard();
        for (Map.Entry<String, String> entry : chips.entrySet())
        {
            Chip chipValue=new Chip("123456789",entry.getKey(),entry.getValue());
            chip.add(chipValue);
        }
        when(daoGame.test()).thenReturn(list);
        when(daoChip.test()).thenReturn(chip);
    }

    @Test
    public void testGame(){
        List<Game> test = service.testGame();
        assertEquals(test, list);
    }

    @Test
    public void testChips(){
        List<Chip> test = service.testChip();
        assertEquals(test, chip);
    }

}
