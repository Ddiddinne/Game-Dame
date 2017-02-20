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
        DataSource ds = JdbcConnectionPool.create("jdbc:h2:mem:dame",
                "sa",
                "");
        DBI dbi = new DBI(ds);
        dao = dbi.open(DaoInterGame.class);
        dao.createTable();

    }

    public void createGame(String token, Piece turn){

        dao.insert(token, turn.toString());
    }

    public Game getTurn(String token){return dao.getTurn(token).get(0);}

    public void updateTurn(String currrentTurn, String token){
        dao.updateTurn(currrentTurn, token);
    }

    public List<Game> test(){
        return dao.test();
    }

    public void removeGame(String token){ dao.removeGame(token);}

}
