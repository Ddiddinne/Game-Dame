package org.isen.dame.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Sandrine on 27/01/2017.
 */
@Data
@Getter
@Setter
@lombok.Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Game {

    @JsonProperty private int id;
    @JsonProperty private String token;
    @JsonProperty private String currentTurn;

}
