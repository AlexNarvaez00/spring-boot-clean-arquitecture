package mx.edu.itoaxaca.api.v1.shared;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonParse {

    public static <T> String toJson(T value) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return mapper.writeValueAsString(value);
    }

    public static <T> T toObject(String value)
        throws JsonMappingException, JsonProcessingException {
        var objectMapper = new ObjectMapper();
        T object = objectMapper.readValue(value, new TypeReference<T>() {});
        return object;
    }
}
