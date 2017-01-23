package org.isen.dame.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.*;
import org.apache.commons.lang.RandomStringUtils;

/**
 * Created by Sandrine on 23/01/2017.
 */
public class DameDao {

    @Inject
    EntityManager em;

    @Inject
    UserTransaction ut;

    public DameAdapter createNewGame() {

        Game game = new Game();
        game.setToken(RandomStringUtils.randomAlphanumeric(10).toLowerCase());
        try {
            ut.begin();
            em.persist(game);
            ut.commit();

        } catch (NotSupportedException | SystemException | SecurityException
                | IllegalStateException | RollbackException
                | HeuristicMixedException | HeuristicRollbackException e) {
            return null;
        }
        return new DameAdapter(this, game);
    }

    public DameAdapter loadFromToken(String token) {

        em.createQuery("SELECT g FROM Game g").getResultList().stream().forEach(r -> System.out.println(((Game)r).getToken()));
        Game game = (Game) em
                .createQuery("SELECT g FROM Game g WHERE g.token = :token")
                .setParameter("token", token).getSingleResult();

        return new DameAdapter(this, game);
    }
}
