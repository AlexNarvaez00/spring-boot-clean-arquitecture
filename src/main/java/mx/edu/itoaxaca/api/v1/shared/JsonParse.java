package mx.edu.itoaxaca.api.v1.shared;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParse {

    public static <T> String toJson(T value) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(value);
    }

    public static <T> T toObject(String value)
        throws JsonMappingException, JsonProcessingException {
        var objectMapper = new ObjectMapper();
        T object = objectMapper.readValue(value, new TypeReference<T>() {});
        return object;
    }
}
