package mx.edu.itoaxaca.api.v1.workshop.domain;

import java.time.LocalDate;
import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.FakerService;

public class WorkshopMother {

    public static Workshop random() {
        var faker = FakerService.create();

        return new Workshop(
            UUID.randomUUID(),
            new WorkshopName(faker.name().firstName()),
            new WorkshopDate(LocalDate.now()),
            new WorkshopSpeaker(faker.name().firstName()),
            new WorkshopSpeakerInstitution(faker.name().firstName()),
            null
        );
    }
}
