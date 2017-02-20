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
import static org.mockito.Matchers.anyString;
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
    }

}
