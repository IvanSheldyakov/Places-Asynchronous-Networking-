package Services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Data;
import model.location.Locations;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Locale;

public class LocationsFinder extends GetRequestExecutor implements Finder {

    private static final String API_KEY = "03c6ba2c-9a55-4a9b-8e2a-f638766e16ac";

    private String location;
    public LocationsFinder(String location) {
        this.location = location;
    }

    @Override
    public void find(Data data) throws IOException {
        data.setLocations(findAllLocationsIn(location));
    }

    private Locations findAllLocationsIn(String location) throws IOException {

        String url = createUrl(location);

        Response response = execute(url);
        var locations = ResponseUtility.takeFromResponse(response,Locations.class);
        response.close();

        return locations;

    }

    private String createUrl(String location) {
        return "https://graphhopper.com/api/1/geocode?q="
               + location.toLowerCase(Locale.ROOT) + "&key=" + API_KEY;
    }


}
