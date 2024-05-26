package mx.edu.itoaxaca.api.v1.tutor.domain;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileMother;
import mx.edu.itoaxaca.api.v1.shared.FakerService;

public class TutorMother {

    public static Tutor random() {
        var faker = FakerService.create().name();

        return new Tutor(
            UUID.randomUUID(),
            new TutorClassification(faker.firstName()),
            ProfileMother.random()
        );
    }
}
