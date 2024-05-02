package mx.edu.itoaxaca.api.v1.type_date.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TypeDateUpdateRequest {
    
    @NotNull
    private String name;

    public TypeDate asTypeDate() {
        return new TypeDate(
            null,
            new TypeDateName(this.name)
        );
    }
}
