package org.isen.dame.webapp.DAO;

import org.isen.dame.core.Game;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.helpers.MapResultAsBean;

import java.util.List;

/**
 * Created by Sandrine on 26/01/2017.
 */
public interface DaoInterGame {

    @MapResultAsBean
    @SqlQuery("select * from games")
    List<Game> test();

    @SqlUpdate("create table IF NOT EXISTS games (id int primary key AUTO_INCREMENT, token varchar(100), currentTurn varchar(50))")
    void createTable();

    @SqlUpdate("insert into games (token, currentTurn) values (:token, :currentTurn)")
    void insert(@Bind("token") String token, @Bind("currentTurn") String currentTurn);


    @SqlQuery("select currentTurn from games where token = :token")
    String getTurn(@Bind("token") String token);

    /*@MapResultAsBean
    @SqlQuery("select token from game where id = :id")
    String test(@Bind("id") int id);*/

    void close();
}
