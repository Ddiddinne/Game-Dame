package org.isen.dame.jpa;

import org.isen.dame.core.Piece;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;

/**
 * Created by Sandrine on 23/01/2017.
 */
@Entity(name="Game")
public class Game {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String token;

    @OneToMany(mappedBy="game", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @OrderColumn(name="index")
    private List<Turn> turns = new ArrayList<>();

    private String currentTurn = Piece.BROWN.toString();

    public Game() {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;

    }

    public List<Turn> getTurns() {
        return turns;
    }

    public Piece getCurrentTurn() {
        return  Piece.valueOf(currentTurn);
    }

    public void setCurrentTurn(Piece colour) {
        currentTurn = colour.toString();
    }

}
