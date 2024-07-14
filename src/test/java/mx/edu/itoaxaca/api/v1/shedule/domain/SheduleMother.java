package mx.edu.itoaxaca.api.v1.shedule.domain;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileMother;
import mx.edu.itoaxaca.api.v1.shared.FakerService;

public class SheduleMother {

    public static Shedule random() {
        var faker = FakerService.create();

        return new Shedule(
            UUID.randomUUID(),
            new SheduleStartHour(faker.number().numberBetween(7, 18)),
            new SheduleEndHour(faker.number().numberBetween(7, 18)),
            new SheduleDay(faker.number().numberBetween(1, 5)),
            ProfileMother.random()
        );
    }
}
