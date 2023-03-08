package model.place;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Place {

    @JsonProperty("properties")
    private PlaceInfo place;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static class PlaceInfo {
        private String name;
        private String xid;
        private String wikidata;
        private String kinds;
        private String rate;
    }

    @Override
    public String toString() {
        return place.toString();
    }
}
