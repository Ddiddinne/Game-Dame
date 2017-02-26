package org.isen.dame.webapp.DAO;

import org.h2.jdbcx.JdbcConnectionPool;
import org.isen.dame.core.Game;
import org.isen.dame.core.Piece;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.skife.jdbi.v2.DBI;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Sandrine on 26/01/2017.
 */
public class DaoGameTest {
    private static DaoInterGame dao;
    private static Game game = Game.builder()
            .token("123456789")
            .currentTurn(Piece.BLACK.toString())
            .build();
    private static Game game1 = Game.builder()
            .token("aaaaaaaaa")
            .currentTurn(Piece.WHITE.toString())
            .build();

    private static Game game2 = Game.builder()
            .token("bbbbbbbbb")
            .currentTurn(Piece.WHITE.toString())
            .build();

    @BeforeClass
    public static void setUpBefore(){
        DataSource ds = JdbcConnectionPool.create("jdbc:h2:mem:test",
                "sa",
                "");
        DBI dbi = new DBI(ds);
        dao = dbi.open(DaoInterGame.class);
        dao.createTable();
        dao.insert(game1.getToken(), game1.getCurrentTurn());
        dao.insert(game2.getToken(), game2.getCurrentTurn());
    }
    @AfterClass
    public static void setUpAfter(){
        dao.close();
    }

    @Test
    public void testInsert(){
        dao.insert(game.getToken(), game.getCurrentTurn());
        List<Game> response = dao.test();
        assertEquals(response.size(), 3);
        assertEquals(response.get(2).getToken(), game.getToken());
        assertEquals(response.get(2).getCurrentTurn(), game.getCurrentTurn());
    }

    @Test
    public void testGetTurn(){
        List<Game> response = dao.getTurn(game1.getToken());
        assertEquals(response.size(), 1);
        assertEquals(response.get(0).getCurrentTurn(), game1.getCurrentTurn());
    }

    @Test
    public void testRemove(){
        List<Game> response = dao.test();
        assertEquals(response.size(), 3);
        dao.removeGame(game.getToken());
        response = dao.test();
        assertEquals(response.size(), 2);
    }

    @Test
    public void testUpdate(){
        List<Game> response = dao.getTurn(game2.getToken());
        assertEquals(response.get(0).getCurrentTurn(), "WHITE");
        dao.updateTurn(Piece.BLACK.toString(), game2.getToken());
        response = dao.getTurn(game2.getToken());
        assertEquals(response.size(), 1);
        assertEquals(response.get(0).getCurrentTurn(), "BLACK");
    }
}
