package model.weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class AllWeatherInfo {

    private ArrayList<Weather> weather;
    private Main main;
    private int visibility;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;

    @Override
    public String toString() {
        return "AllWeatherInfo{\n" +
                "weather=" + weather +
                "\nmain=" + main +
                "\nvisibility=" + visibility +
                "\nwind=" + wind +
                "\nrain=" + rain +
                "\nclouds=" + clouds +
                '}' + '\n';
    }
}
