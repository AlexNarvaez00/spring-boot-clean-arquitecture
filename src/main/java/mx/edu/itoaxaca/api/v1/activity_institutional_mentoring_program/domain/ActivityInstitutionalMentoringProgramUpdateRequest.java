package mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Data;
import mx.edu.itoaxaca.api.v1.strategy.domain.Strategy;

@Data
public class ActivityInstitutionalMentoringProgramUpdateRequest {

    @NotNull
    private String name;

    @NotNull
    private UUID straegy_id;

    public ActivityInstitutionalMentoringProgram asActivityInstitutionalMentoringProgram() {
        return new ActivityInstitutionalMentoringProgram(
            null,
            new ActivityInstitutionalMentoringProgramName(this.name),
            new Strategy(this.straegy_id, null, null)
        );
    }
}
