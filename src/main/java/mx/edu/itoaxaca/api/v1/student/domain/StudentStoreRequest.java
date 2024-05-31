package mx.edu.itoaxaca.api.v1.student.domain;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Setter
public class StudentStoreRequest {

    private UUID id;

    @NotNull
    private String control_number;

    @NotNull
    private UUID profile_id;

    public Student asStudent() {
        return new Student(
            (this.id == null) ? null : UUID.randomUUID(),
            new StudentControlNumber(this.control_number),
            new Profile(profile_id, null, null, null, null)
        );
    }
}
