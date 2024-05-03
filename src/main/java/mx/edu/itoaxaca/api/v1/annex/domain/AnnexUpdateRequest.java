package mx.edu.itoaxaca.api.v1.annex.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotNull;
import java.util.HashMap;
import lombok.Data;

@Data
public class AnnexUpdateRequest {

    @NotNull
    private String name;

    @NotNull
    private String body;

    public Annex asAnnex() throws JsonMappingException, JsonProcessingException {
        var objectMapper = new ObjectMapper();
        HashMap<String, Object> jsonToHasmap = objectMapper.readValue(
            body,
            new TypeReference<>() {}
        );
        return new Annex(null, new AnnexName(this.name), new AnnexBody(jsonToHasmap));
    }
}
