package org.isen.dame.core;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Sandrine on 27/01/2017.
 */
@Data
@XmlRootElement
public class Chip {
    @JsonProperty private String token;
    @JsonProperty private String position;
    @JsonProperty private String piece;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public Chip(String token, String position, String piece){
        this.token=token;
        this.position=position;
        this.piece=piece;
    }
}
