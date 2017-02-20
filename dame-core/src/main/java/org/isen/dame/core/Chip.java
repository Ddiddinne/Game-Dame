package org.isen.dame.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Builder;

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
public class Chip {

    @JsonProperty private String token;
    @JsonProperty private String position;
    @JsonProperty private String piece;


}
