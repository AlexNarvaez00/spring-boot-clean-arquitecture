package mx.edu.itoaxaca.api.v1.strategy.domain;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain.InstitutionalMentoringProgram;
import mx.edu.itoaxaca.api.v1.shared.FakerService;

public class StrategyMother {

    public static Strategy random() {
        var faker = FakerService.create();

        return new Strategy(
            UUID.randomUUID(),
            new StrategyName(faker.name().firstName()),
            new InstitutionalMentoringProgram(UUID.randomUUID(), null, null)
        );
    }
}
