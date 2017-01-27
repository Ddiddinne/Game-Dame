package org.isen.dame.webapp.DAO;

import org.h2.jdbcx.JdbcConnectionPool;
import org.isen.dame.core.Chip;
import org.isen.dame.core.Piece;
import org.skife.jdbi.v2.DBI;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Sandrine on 27/01/2017.
 */
public class DaoChip {

    private DaoInterChip dao;
    public DaoChip(){
        DataSource ds = JdbcConnectionPool.create("jdbc:h2:mem:test",
                "sa",
                "");
        DBI dbi = new DBI(ds);
        dao = dbi.open(DaoInterChip.class);
        dao.createTable();

    }

    public void createBoard(String token, String position, Piece piece){

        dao.insert(token, position, piece.toString());
    }

    public List<Chip> getChips(String token){
        return dao.getFromToken(token);
    }
    public List<Chip> test(){
        return dao.test();
    }
}
