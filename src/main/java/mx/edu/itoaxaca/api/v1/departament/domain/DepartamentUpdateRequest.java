package mx.edu.itoaxaca.api.v1.departament.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DepartamentUpdateRequest {

    @NotEmpty
    private String name;

    public Departament asDepartament() {
        return new Departament(null, new DepartamentName(this.name));
    }
}
