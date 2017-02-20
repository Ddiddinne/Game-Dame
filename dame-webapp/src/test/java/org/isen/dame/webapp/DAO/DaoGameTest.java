package org.isen.dame.webapp.DAO;

import org.h2.jdbcx.JdbcConnectionPool;
import org.isen.dame.core.Game;
import org.isen.dame.core.Piece;
import org.junit.After;
import org.junit.Before;
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
    private DaoInterGame dao;
    private Game game = Game.builder()
            .token("123456789")
            .currentTurn(Piece.BLACK.toString())
            .build();

    @Before
    public void setUpBefore(){
        DataSource ds = JdbcConnectionPool.create("jdbc:h2:mem:test",
                "sa",
                "");
        DBI dbi = new DBI(ds);
        dao = dbi.open(DaoInterGame.class);
        dao.createTable();
    }
    @After
    public void setUpAfter(){
        dao.close();
    }

    @Test
    public void testInsert(){
        dao.insert(game.getToken(), game.getCurrentTurn());
        List<Game> response = dao.test();
        assertEquals(response.size(), 1);
        assertEquals(response.get(0).getToken(), game.getToken());
        assertEquals(response.get(0).getCurrentTurn(), game.getCurrentTurn());
    }
}
