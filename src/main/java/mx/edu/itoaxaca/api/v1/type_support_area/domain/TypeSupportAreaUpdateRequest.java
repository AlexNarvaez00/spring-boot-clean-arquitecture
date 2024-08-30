package mx.edu.itoaxaca.api.v1.type_support_area.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Setter;

@Setter
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
