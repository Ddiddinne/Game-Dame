package org.isen.dame.jpa;


import org.isen.dame.jpa.guice.GuiceRunner;
import org.isen.dame.jpa.guice.H2DBModule;
import org.isen.dame.jpa.guice.Modules;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(GuiceRunner.class)
@Modules({ H2DBModule.class, JPAModule.class })
public class DameDAOTest {

    @Inject
    EntityManager em;

    @Inject
    DameDao dao;

    @Test
    public void daoIsInjected() throws Exception {
        assertThat(dao).isNotNull();
    }

    @Test
    public void itCanCreateAGame() throws Exception {
        DameAdapter game = dao.createNewGame();
        assertThat(game).isNotNull();

        String token = game.getToken();
        assertThat(game.getToken()).isNotNull();
        em.clear();
        game = dao.loadFromToken(token);
        assertThat(game).isNotNull();

    }

    /*@Test
    public void itCanPlayWithAJPAGame() throws Exception {
        DameAdapter game = dao.createNewGame();
        game.play(ChipColour.RED, 3);
        game.play(ChipColour.RED, 3);
        game.play(ChipColour.YELLOW, 3);
        game.play(ChipColour.YELLOW, 3);
        game.play(ChipColour.RED, 3);

        assertThat(game.getCell(3, 0)).isEqualTo(ChipColour.RED);
        assertThat(game.getCell(3, 1)).isEqualTo(ChipColour.RED);
        assertThat(game.getCell(3, 2)).isEqualTo(ChipColour.YELLOW);
        assertThat(game.getCell(3, 3)).isEqualTo(ChipColour.YELLOW);
        assertThat(game.getCell(3, 4)).isEqualTo(ChipColour.RED);
        String token = game.getToken();

        em.clear();
        game = dao.loadFromToken(token);
        assertThat(game).isNotNull();
        assertThat(game.getCell(3, 0)).isEqualTo(ChipColour.RED);
        assertThat(game.getCell(3, 1)).isEqualTo(ChipColour.RED);
        assertThat(game.getCell(3, 2)).isEqualTo(ChipColour.YELLOW);
        assertThat(game.getCell(3, 3)).isEqualTo(ChipColour.YELLOW);
        assertThat(game.getCell(3, 4)).isEqualTo(ChipColour.RED);

    }

    @Test
    public void adapterManagesTurns() throws Exception {
        Puissance4Adapter game = dao.createNewGame();
        assertThat(game.getCurrentTurn()).isNotNull();
        assertThat(game.getCurrentTurn()).isEqualTo(ChipColour.RED);
        game.play(game.getCurrentTurn(), 3);
        game = dao.loadFromToken(game.getToken());
        assertThat(game.getCurrentTurn()).isEqualTo(ChipColour.YELLOW);
        game.play(game.getCurrentTurn(), 3);
        game = dao.loadFromToken(game.getToken());
        assertThat(game.getCurrentTurn()).isEqualTo(ChipColour.RED);

    }*/
}
