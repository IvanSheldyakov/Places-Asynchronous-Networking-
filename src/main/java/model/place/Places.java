package model.place;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Places {
    @JsonProperty("features")
    private ArrayList<Place> places;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < places.size(); i++) {
            builder.append(i+1).append(") ").append(places.get(i)).append("\n");
        }
        return builder.toString();
    }

    public int getAmount() {
        return places.size();
    }

    public String getXidOfPlaceById(int id) {
        return places.get(id).getPlace().getXid();
    }
}
