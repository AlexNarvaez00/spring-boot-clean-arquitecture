package mx.edu.itoaxaca.api.v1.type_support_area.domain;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.PostgresTypeSupportArea;

@Setter
public class TypeSupportAreaStoreRequest {
    private UUID id;

    @NotNull
    private String type;

    public PostgresTypeSupportArea asTypeSupportArea() {
        return new PostgresTypeSupportArea(
            (this.id == null) ? null : UUID.randomUUID(),
            new TypeSupportAreaType(this.type)
        );
    }
}
