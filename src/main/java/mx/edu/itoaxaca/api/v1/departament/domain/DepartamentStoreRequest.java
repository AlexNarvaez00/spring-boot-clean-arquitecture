package mx.edu.itoaxaca.api.v1.departament.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Setter
public class DepartamentStoreRequest {

    private UUID id;

    @NotEmpty
    private String name;

    @NotNull
    private UUID departament_coordinator_id;

    public Departament asDepartament() {
        return new Departament(
            (id == null) ? UUID.randomUUID() : id,
            new DepartamentName(this.name),
            new Profile(this.departament_coordinator_id,null,null,null,null)
        );
    }
}
