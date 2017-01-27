package org.isen.dame.webapp.DAO;


import org.apache.commons.lang.RandomStringUtils;
import org.h2.jdbcx.JdbcConnectionPool;
import org.isen.dame.core.Game;
import org.isen.dame.core.Piece;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import javax.sql.DataSource;
import java.util.List;


/**
 * Created by Sandrine on 26/01/2017.
 */
public class DaoGame {

    private DaoInterGame dao;

    public DaoGame(){
        DataSource ds = JdbcConnectionPool.create("jdbc:h2:mem:test",
                "sa",
                "");
        DBI dbi = new DBI(ds);
        dao = dbi.open(DaoInterGame.class);
        dao.createTable();

    }

    public void createGame(String token, Piece turn){

        dao.insert(token, turn.toString());
    }

    public List<Game> test(){
        return dao.test();
    }

}
