package Services;

import model.Data;
import model.location.Point;
import model.place.Places;
import okhttp3.Response;

import java.io.IOException;

public class InterestingPlacesFinder extends GetRequestExecutor implements Finder{

    private static final String API_KEY = "5ae2e3f221c38a28845f05b6ff12ff554383636399d42c0191af3021";

    private int id;
    public InterestingPlacesFinder(int id) {
        this.id = id;
    }

    @Override
    public void find(Data data) throws IOException {
        data.setPlaces(findPlaces(data.getCoordsOfLocationById(id)));
    }

    private Places findPlaces(Point coords) throws IOException {
        String url = createUrl(coords);

        Response response = execute(url);

        Places places = ResponseUtility.takeFromResponse(response,Places.class);

        response.close();
        return places;
    }

    private String createUrl(Point coords) {
        return String.format(" https://api.opentripmap.com/0.1/ru/places/radius?" +
                "radius=2000&lon=%f&lat=%f&apikey=%s",coords.getLng(),coords.getLat(),API_KEY);
    }
}
