package mx.edu.itoaxaca.api.v1.annex.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Data;
import mx.edu.itoaxaca.api.v1.shared.JsonParse;

@Data
public class AnnexStoreRequest {

    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private Object body;

    public Annex asAnnex() throws JsonMappingException, JsonProcessingException {
        return new Annex(
            (this.id == null) ? null : UUID.randomUUID(),
            new AnnexName(this.name),
            new AnnexBody(JsonParse.toObject(JsonParse.toJson(this.body)))
        );
    }
}
