package mx.edu.itoaxaca.api.v1.career.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.departament.domain.Departament;

@Setter
public class CareerUpdateRequest {

    @NotEmpty
    private String name;

    @NotNull
    private UUID departament_id;

    public Career asCareer() {
        return new Career(
            null,
            new CareerName(this.name),
            new Departament(this.departament_id, null)
        );
    }
}
