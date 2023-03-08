package model.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Location {

    @JsonProperty("osm_id")
    private long osmId;

    @JsonProperty("osm_type")
    private String osmType;

    private String country;

    @JsonProperty("osm_key")
    private String osmKey;

    @JsonProperty("osm_value")
    private String osmValue;

    private String name;

    private Point point;


}
