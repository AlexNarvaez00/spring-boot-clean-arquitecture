package mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActivityInstitutionalMentoringProgramStoreRequest {
    private UUID id;

    @NotNull
    private String name;

    public ActivityInstitutionalMentoringProgram asActivityInstitutionalMentoringProgram() {
        return new ActivityInstitutionalMentoringProgram(
            (this.id == null) ? null : UUID.randomUUID(),
            new ActivityInstitutionalMentoringProgramName(this.name)
        );
    }
}
