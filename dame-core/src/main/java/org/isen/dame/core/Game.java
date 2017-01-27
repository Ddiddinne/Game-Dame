package org.isen.dame.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Sandrine on 27/01/2017.
 */
@Data
@XmlRootElement
public class Game {
    @JsonProperty private int id;
    @JsonProperty private String token;
    @JsonProperty private String currentTurn;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;

    }
    public Piece getCurrentTurn() {
        return  Piece.valueOf(currentTurn);
    }

    public void setCurrentTurn(Piece colour) {
        currentTurn = colour.toString();
    }
}
