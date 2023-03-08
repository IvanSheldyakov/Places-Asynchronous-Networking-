package Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.location.Locations;
import okhttp3.Response;

import java.io.IOException;

public class ResponseUtility {

    public static  <T> T takeFromResponse(Response response, Class<T> clazz) throws IOException {
        ObjectMapper mapper = ObjectMapperInitializer.initWithoutDeserializationFailOnUnknownProperties();
        assert response.body() != null;
        return mapper.readValue(response.body().byteStream(), clazz);
    }
}
