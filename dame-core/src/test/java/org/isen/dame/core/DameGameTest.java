package org.isen.dame.core;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Sandrine on 09/01/2017.
 */
public class DameGameTest {
    private DameGame game;

    @Before
    public void doBefore(){
        game = new DameGameImpl();
    }

    @Test
    public void canInstanciateTheGame(){
        assertThat(game).isNotNull();
        assertThat(game.getCell("A",1)).isEqualTo(Piece.WHITE);
        assertThat(game.getCell("G",1)).isEqualTo(Piece.WHITE);
        assertThat(game.getCell("I",1)).isNull();
        assertThat(game.getCell("B",1)).isNull();
        assertThat(game.getCell("B",8)).isEqualTo(Piece.BLACK);
    }

    @Test
    public void playerMove(){
        game.play("A", 3, Direction.RIGHT);
        assertThat(game.getCell("A", 3)).isNull();
        assertThat(game.getCell("B", 4)).isEqualTo(Piece.WHITE);

        game.play("E", 3, Direction.LEFT);
        assertThat(game.getCell("E", 3)).isNull();
        assertThat(game.getCell("D", 4)).isEqualTo(Piece.WHITE);
    }

}
