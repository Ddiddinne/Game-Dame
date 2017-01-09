package org.isen.dame.core;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
        HashMap<String, Integer> direction1 = new HashMap<>();
        direction1.put("x",1);
        direction1.put("y",1);
        game.play("A", 3, direction1);
        assertThat(game.getCell("A", 3)).isNull();
        assertThat(game.getCell("B", 4)).isEqualTo(Piece.WHITE);

        direction1.put("x",-1);
        game.play("E", 3, direction1);
        assertThat(game.getCell("E", 3)).isNull();
        assertThat(game.getCell("D", 4)).isEqualTo(Piece.WHITE);

        direction1.put("y", -1);
        game.play("B", 6, direction1);
        assertThat(game.getCell("B", 6)).isNull();
        assertThat(game.getCell("A", 5)).isEqualTo(Piece.BLACK);

        direction1.put("x", 1);
        game.play("D", 6, direction1);
        assertThat(game.getCell("D", 6)).isNull();
        assertThat(game.getCell("E", 5)).isEqualTo(Piece.BLACK);

        game.play("D", 8, direction1);
        assertThat(game.getCell("D", 8)).isEqualTo(Piece.BLACK);

    }

}
