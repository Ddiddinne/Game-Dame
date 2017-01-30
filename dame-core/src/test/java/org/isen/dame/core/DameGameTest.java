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
        assertThat(game.getCell("A",1)).isEqualTo(Piece.BLACK.toString());
        assertThat(game.getCell("G",1)).isEqualTo(Piece.BLACK.toString());
        assertThat(game.getCell("I",1)).isNull();
        assertThat(game.getCell("B",1)).isNull();
        assertThat(game.getCell("B",8)).isEqualTo(Piece.WHITE.toString());
    }

    @Test
    public void playerMove(){
        HashMap<String, Integer> direction1 = new HashMap<>();
        direction1.put("x",1);
        direction1.put("y",1);
        Position posInit = new Position();
        posInit.row = 3;
        posInit.column = "A";
        Position posFinal = new Position();
        posFinal.row =4;
        posFinal.column = "B";
        game.play(Piece.BLACK, posInit, posFinal);
        assertThat(game.getCell("A", 3)).isNull();
        assertThat(game.getCell("B", 4)).isEqualTo(Piece.BLACK.toString());


        posInit.row = 3;
        posInit.column = "E";
        posFinal.row =4;
        posFinal.column = "D";
        direction1.put("x",-1);
        game.play(Piece.BLACK, posInit, posFinal);
        assertThat(game.getCell("E", 3)).isNull();
        assertThat(game.getCell("D", 4)).isEqualTo(Piece.BLACK.toString());

        posInit.row = 6;
        posInit.column = "B";
        posFinal.row =5;
        posFinal.column = "A";
        game.play(Piece.WHITE, posInit, posFinal);
        assertThat(game.getCell("B", 6)).isNull();
        assertThat(game.getCell("A", 5)).isEqualTo(Piece.WHITE.toString());

        posInit.row = 6;
        posInit.column = "D";
        posFinal.row =5;
        posFinal.column = "E";
        game.play(Piece.WHITE, posInit, posFinal);
        assertThat(game.getCell("D", 6)).isNull();
        assertThat(game.getCell("E", 5)).isEqualTo(Piece.WHITE.toString());

    }

}
