package mx.edu.itoaxaca.api.v1.profile.domain;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.FakerService;

public class ProfileMother {

    public static Profile random() {
        var faker = FakerService.create();

        return new Profile(
            UUID.randomUUID(),
            new ProfileName(faker.name().firstName()),
            new ProfileEmail(faker.internet().emailAddress()),
            new ProfilePassword(faker.internet().password()),
            null
        );
    }
}
