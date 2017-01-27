package org.isen.dame.webapp.DAO;

import org.isen.dame.core.Chip;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.helpers.MapResultAsBean;

import java.util.List;

/**
 * Created by Sandrine on 27/01/2017.
 */
public interface DaoInterChip {

    @MapResultAsBean
    @SqlQuery("select * from chips")
    List<Chip> test();

    @SqlUpdate("create table IF NOT EXISTS chips (id int primary key AUTO_INCREMENT, token varchar(100), position varchar(2), piece varchar(50))")
    void createTable();

    @SqlUpdate("insert into chips (token, position, piece) values (:token, :position, :piece)")
    void insert(@Bind("token") String token, @Bind("position") String position, @Bind("piece") String piece);

    @MapResultAsBean
    @SqlQuery("select * from chips where token = :token")
    List<Chip> getFromToken(@Bind("token") String token);

}
