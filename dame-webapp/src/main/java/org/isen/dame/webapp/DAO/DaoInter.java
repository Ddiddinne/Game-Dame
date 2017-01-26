package org.isen.dame.webapp.DAO;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

/**
 * Created by Sandrine on 26/01/2017.
 */
public interface DaoInter {

    @SqlUpdate("create table IF NOT EXISTS game (id int primary key AUTO_INCREMENT, token varchar(100), currentTurn varchar(50), turns int)")
    void createTable();

    @SqlUpdate("insert into game (token) values (:name)")
    void insert(@Bind("name") String name);

    @SqlQuery("select token from game where id = :id")
    String test(@Bind("id") int id);

    void close();
}
