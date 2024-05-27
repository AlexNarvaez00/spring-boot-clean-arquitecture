package mx.edu.itoaxaca.api.v1.teacher.domain;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.departament.domain.Departament;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Setter
public class TeacherStoreRequest {

    private UUID id;

    @NotNull
    private String type;

    @NotNull
    private UUID profile_id;

    @NotNull
    private UUID departament_id;

    public Departament getDepartament() {
        return new Departament(this.departament_id, null);
    }

    public Teacher asTeacher() {
        return new Teacher(
            (this.id == null) ? UUID.randomUUID() : this.id,
            new TeacherType(this.type),
            new Profile(this.profile_id, null, null, null, null)
        );
    }
}
