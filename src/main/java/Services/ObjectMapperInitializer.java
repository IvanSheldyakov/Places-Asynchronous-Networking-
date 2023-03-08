package Services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperInitializer {
    public static ObjectMapper initWithoutDeserializationFailOnUnknownProperties() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setConfig(mapper.getDeserializationConfig().without(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES));
        return mapper;
    }
}
