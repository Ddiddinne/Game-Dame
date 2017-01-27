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


}
