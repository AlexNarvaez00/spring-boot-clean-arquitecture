package mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.strategy.domain.Strategy;

@Setter
public class ActivityInstitutionalMentoringProgramStoreRequest {

    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private UUID straegy_id;

    public ActivityInstitutionalMentoringProgram asActivityInstitutionalMentoringProgram() {
        return new ActivityInstitutionalMentoringProgram(
            (this.id == null) ? null : UUID.randomUUID(),
            new ActivityInstitutionalMentoringProgramName(this.name),
            new Strategy(this.straegy_id, null, null)
        );
    }
}
