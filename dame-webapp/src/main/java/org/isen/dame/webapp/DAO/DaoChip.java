package org.isen.dame.webapp.DAO;

import org.h2.jdbcx.JdbcConnectionPool;
import org.isen.dame.core.Chip;
import org.skife.jdbi.v2.DBI;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Sandrine on 27/01/2017.
 */
public class DaoChip {

    private DaoInterChip dao;
    public DaoChip(){
        DataSource ds = JdbcConnectionPool.create("jdbc:h2:mem:dame",
                "sa",
                "");
        DBI dbi = new DBI(ds);
        dao = dbi.open(DaoInterChip.class);
        dao.createTable();

    }

    public void createBoard(String token, String position, String piece){

        dao.insert(token, position, piece.toString());
    }

    public List<Chip> getChips(String token){
        return dao.getFromToken(token);
    }

    public String getColor(String token, String position){ return dao.getColor(token, position);}

    public List<Chip> test(){
        return dao.test();
    }

    public void updateChip(String token, String position, String newposition){dao.updateChip(token, position, newposition);}

    public void removeChip(String token, String position){dao.removeChip(token, position);}

    public void removeGame(String token){dao.removeGame(token);}
}
