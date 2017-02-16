package org.isen.dame.webapp.service;

import org.isen.dame.core.DameGame;
import org.isen.dame.core.DameGameImpl;
import org.isen.dame.core.Game;
import org.isen.dame.webapp.DAO.DaoChip;
import org.isen.dame.webapp.DAO.DaoGame;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Before
    public void setUp(){
        game = new Game();
        game.setToken("123456789");
        list = new ArrayList<>();
        list.add(game);
        when(daoGame.test()).thenReturn(list);
    }

    @Test
    public void testGame(){

        List<Game> test = service.testGame();
        assertEquals(test, list);

    }
}
