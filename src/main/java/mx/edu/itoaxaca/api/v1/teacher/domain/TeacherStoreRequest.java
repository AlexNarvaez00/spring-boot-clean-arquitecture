package mx.edu.itoaxaca.api.v1.teacher.domain;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Data;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Data
public class TeacherStoreRequest {

    private UUID id;

    @NotNull
    private String type;

    @NotNull
    private UUID profile_id;

    public Teacher asTeacher() {
        return new Teacher(
            (this.id == null) ? null : UUID.randomUUID(),
            new TeacherType(this.type),
            new Profile(this.profile_id, null, null, null, null, null)
        );
    }
}
