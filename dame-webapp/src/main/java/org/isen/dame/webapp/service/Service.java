package org.isen.dame.webapp.service;

import org.isen.dame.webapp.DAO.Dao;
import org.isen.dame.webapp.DAO.DaoInter;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by Sandrine on 26/01/2017.
 */

public class Service {
    private Dao dao = new Dao();

    public String createNewGame(){
        return dao.DacTest();

    }
}
