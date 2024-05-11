package mx.edu.itoaxaca.api.v1.student.domain;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Data
public class StudentUpdateRequest {
    
    @NotNull
    private String control_number;

    @NotNull
    private UUID profile_id;

    public Student asStudent() {
        return new Student(
            null,
            new StudentControlNumber(this.control_number),
            new Profile(profile_id, null, null, null, null, null)
        );
    }
}
