package org.isen.dame.webapp.model;

import org.isen.dame.core.Piece;

import javax.persistence.*;

@Entity
public class Turn {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;

    @ManyToOne
    Game game;

    private String colour;

    @Column(name="col")
    private int column;

    public Turn() {

    }

    public Turn(Game game, Piece colour, int column) {
        this.game = game;
        this.colour = colour.toString();
        this.column = column;
    }

    public Piece getColour() {
        return Piece.valueOf(colour);
    }

    public int getColumn() {
        return column;
    }


}
