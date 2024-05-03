package mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActivityInstitutionalMentoringProgramUpdateRequest {
    
    @NotNull
    private String name;

    public ActivityInstitutionalMentoringProgram asActivityInstitutionalMentoringProgram() {
        return new ActivityInstitutionalMentoringProgram(
            null,
            new ActivityInstitutionalMentoringProgramName(this.name)
        );
    }
}
