package mx.edu.itoaxaca.api.v1.teacher.domain;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Setter
public class TeacherUpdateRequest {

    @NotNull
    private String type;

    @NotNull
    private UUID profile_id;

    public Teacher asTeacher() {
        return new Teacher(
            null,
            new TeacherType(this.type),
            new Profile(this.profile_id, null, null, null, null)
        );
    }
}
