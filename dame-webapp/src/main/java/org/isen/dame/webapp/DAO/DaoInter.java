package org.isen.dame.webapp.DAO;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.helpers.MapResultAsBean;

/**
 * Created by Sandrine on 26/01/2017.
 */
public interface DaoInter {

    @SqlUpdate("create table IF NOT EXISTS game (id int primary key AUTO_INCREMENT, token varchar(100), currentTurn varchar(50))")
    void createTable();

    @SqlUpdate("insert into game (token, currentTurn) values (:token, :currentTurn)")
    void insert(@Bind("token") String token, @Bind("currentTurn") String currentTurn);

    @MapResultAsBean
    @SqlQuery("select token from game where id = :id")
    String test(@Bind("id") int id);

    //@SqlQuery("select * from game")

    void close();
}
