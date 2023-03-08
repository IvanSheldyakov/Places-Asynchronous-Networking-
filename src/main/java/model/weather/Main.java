package model.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Main {

    private double temp;
    @JsonProperty("feels_like")
    private double feelsLike;
    @JsonProperty("temp_min")
    private double tempMin;
    @JsonProperty("temp_max")
    private double tempMax;
    private int pressure;
    private int humidity;
    @JsonProperty("sea_level")
    private int seaLevel;
    @JsonProperty("grnd_level")
    private int grndLevel;

}
