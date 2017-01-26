package org.isen.dame.webapp.DAO;


import org.h2.jdbcx.JdbcConnectionPool;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.util.StringMapper;

import javax.sql.DataSource;


/**
 * Created by Sandrine on 26/01/2017.
 */
public class Dao {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/Dame";

    static final String USER = "sa";
    static final String PASS = "";
    private Handle h;
    DaoInter dao;

    public Dao(){
        DataSource ds = JdbcConnectionPool.create("jdbc:h2:mem:test",
                "sa",
                "");
        DBI dbi = new DBI(ds);
        dao = dbi.open(DaoInter.class);


    }

    public String DacTest(){
        dao.createTable();
        dao.insert("Titi");
        return dao.test(1);
    }

}
