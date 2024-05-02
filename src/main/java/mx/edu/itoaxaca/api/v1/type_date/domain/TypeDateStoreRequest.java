package mx.edu.itoaxaca.api.v1.type_date.domain;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TypeDateStoreRequest {
    private UUID id;

    @NotNull
    private String name;

    public TypeDate asTypeDate() {
        return new TypeDate(
            (this.id == null) ? null : UUID.randomUUID(),
            new TypeDateName(this.name)
        );
    }
}
