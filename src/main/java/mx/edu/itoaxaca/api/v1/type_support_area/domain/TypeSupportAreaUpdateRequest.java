package mx.edu.itoaxaca.api.v1.type_support_area.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TypeSupportAreaUpdateRequest {
    
    @NotNull
    private String type;

    public TypeSupportArea asTypeSupportArea() {
        return new TypeSupportArea(
            null,
            new TypeSupportAreaType(this.type)
        );
    }
}
