package org.isen.dame.webapp;

import org.isen.dame.core.DameGame;
import org.isen.dame.jpa.DameAdapter;
import org.isen.dame.jpa.DameDao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Sandrine on 23/01/2017.
 */

@Named("game")
@RequestScoped
public class DameBean implements Serializable{

    DameAdapter game ;

    @Inject
    DameDao dao;

    public void createNewGame() {
        game = dao.createNewGame();
    }

    public DameGame getGame(){return game;}

    public String getToken() {
        return game.getToken();
    }

    public void loadFromToken(String token) {
        game = dao.loadFromToken(token);

    }
}
