package Services;

import model.Data;
import model.place.PlaceDescription;
import okhttp3.Response;

import java.io.IOException;

public class InterestingPlaceDescriptionFinder extends GetRequestExecutor implements Finder {

    private static final String API_KEY = "5ae2e3f221c38a28845f05b6ff12ff554383636399d42c0191af3021";

    private int id;

    public InterestingPlaceDescriptionFinder(int id) {
        this.id = id;
    }

    @Override
    public void find(Data data) throws IOException {
        data.setDescription(findByXid(data.getXidById(id)));
    }

    private PlaceDescription findByXid(String xid) throws IOException {
        String url = createUrl(xid);
        Response response = execute(url);
        PlaceDescription description = ResponseUtility.takeFromResponse(response,PlaceDescription.class);
        response.close();
        return description;
    }


    private String createUrl(String xid) {
        return String.format(" https://api.opentripmap.com/0.1/ru/places/xid/%s?apikey=%s",xid, API_KEY);
    }


}
