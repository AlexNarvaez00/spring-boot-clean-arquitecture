package mx.edu.itoaxaca.api.v1.departament.domain;

import jakarta.validation.constraints.NotEmpty;
import java.util.UUID;
import lombok.Setter;

@Setter
public class DepartamentStoreRequest {

    private UUID id;

    @NotEmpty
    private String name;

    public Departament asDepartament() {
        return new Departament(
            (id == null) ? UUID.randomUUID() : id,
            new DepartamentName(this.name)
        );
    }
}
