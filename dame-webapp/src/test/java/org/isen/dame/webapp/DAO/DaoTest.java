package org.isen.dame.webapp.DAO;

import org.h2.jdbcx.JdbcConnectionPool;
import org.isen.dame.webapp.service.Service;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.util.StringMapper;

import javax.inject.Provider;
import javax.sql.DataSource;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Sandrine on 26/01/2017.
 */
public class DaoTest {
    private Dao dao = new Dao();

    @Ignore
    @Test
    public void test(){
        //String name = dao.testDAO();
        //assertThat(name, equalTo("Brian"));
    }
}
