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
    }

    @Test
    public void playerMove(){
        /*game.play();
        assertThat().isEqualTo(1);*/
    }

}
