package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.location.Locations;
import model.location.Point;
import model.place.PlaceDescription;
import model.place.Places;
import model.weather.AllWeatherInfo;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Data {
    private Locations locations;
    private AllWeatherInfo weatherInfo;
    private Places places;
    private PlaceDescription description;

    public Point getCoordsOfLocationById(int id) {
        return locations.getCoordsOfLocationById(id);
    }

    public String getXidById(int id) {
        return places.getXidOfPlaceById(id);
    }
}
