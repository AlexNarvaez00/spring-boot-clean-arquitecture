package mx.edu.itoaxaca.api.v1.type_support_area.domain;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TypeSupportAreaStoreRequest {
    private UUID id;

    @NotNull
    private String type;

    public TypeSupportArea asTypeSupportArea() {
        return new TypeSupportArea(
            (this.id == null) ? null : UUID.randomUUID(),
            new TypeSupportAreaType(this.type)
        );
    }
}
