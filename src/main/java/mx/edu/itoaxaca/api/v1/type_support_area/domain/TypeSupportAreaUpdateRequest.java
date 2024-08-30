package mx.edu.itoaxaca.api.v1.type_support_area.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.PostgresTypeSupportArea;

@Setter
public class TypeSupportAreaUpdateRequest {
    
    @NotNull
    private String type;

    public PostgresTypeSupportArea asTypeSupportArea() {
        return new PostgresTypeSupportArea(
            null,
            new TypeSupportAreaType(this.type)
        );
    }
}
