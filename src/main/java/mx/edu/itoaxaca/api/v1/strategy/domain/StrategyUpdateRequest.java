package mx.edu.itoaxaca.api.v1.strategy.domain;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain.InstitutionalMentoringProgram;

@Setter
public class StrategyUpdateRequest {

    @NotNull
    private String name;

    @NotNull
    private UUID institutional_mentoring_program;

    public Strategy asStrategy() {
        return new Strategy(
            null,
            new StrategyName(this.name),
            new InstitutionalMentoringProgram(
                this.institutional_mentoring_program,
                null,
                null
            )
        );
    }
}
