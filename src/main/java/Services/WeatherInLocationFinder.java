package Services;

import model.Data;
import model.location.Point;
import model.weather.AllWeatherInfo;
import okhttp3.Response;

import java.io.IOException;

public class WeatherInLocationFinder extends GetRequestExecutor implements Finder {

    private static final String API_KEY = "841b98625e5b4cf5cbc0f3a3e544a220";

    private int id;

    public WeatherInLocationFinder(int id) {
        this.id = id;
    }

    @Override
    public void find(Data data) throws IOException {
        data.setWeatherInfo(findByCoords(data.getCoordsOfLocationById(id)));
    }

    private AllWeatherInfo findByCoords(Point coords) throws IOException {
        String url = createUrl(coords);
        Response response = execute(url);

        AllWeatherInfo info  = ResponseUtility.takeFromResponse(response,AllWeatherInfo.class);
        response.close();
        return info;
    }

    private String createUrl(Point coords) {
        return String.format("https://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&appid=%s",
                coords.getLat(),coords.getLng(),API_KEY);
    }


}
