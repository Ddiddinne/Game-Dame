package org.isen.dame.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Sandrine on 27/01/2017.
 */
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Game {

    @JsonProperty private int id;
    @JsonProperty private String token;
    @JsonProperty private String currentTurn;

}
