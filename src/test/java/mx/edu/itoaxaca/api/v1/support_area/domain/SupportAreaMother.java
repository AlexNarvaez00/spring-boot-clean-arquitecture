package mx.edu.itoaxaca.api.v1.support_area.domain;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.FakerService;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaMother;

public class SupportAreaMother {

    public static SupportArea random() {
        var faker = FakerService.create();
        return new SupportArea(
            UUID.randomUUID(),
            new SupportAreaName(faker.lorem().paragraph(4)),
            new SupportAreaShortName(faker.name().firstName()),
            TypeSupportAreaMother.random()
        );
    }
}
