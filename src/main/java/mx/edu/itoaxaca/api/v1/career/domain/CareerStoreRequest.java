package mx.edu.itoaxaca.api.v1.career.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Data;
import mx.edu.itoaxaca.api.v1.departament.domain.Departament;

@Data
public class CareerStoreRequest {

    private UUID id;

    @NotEmpty
    private String name;

    @NotNull
    private UUID departament_id;

    public Career asCareer() {
        System.out.print(this.departament_id);
        return new Career(
            (id == null) ? UUID.randomUUID() : id,
            new CareerName(this.name),
            new Departament(this.departament_id, null)
        );
    }
}
