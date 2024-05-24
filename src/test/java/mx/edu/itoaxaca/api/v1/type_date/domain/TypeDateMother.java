package mx.edu.itoaxaca.api.v1.type_date.domain;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.FakerService;

public class TypeDateMother {

    public static TypeDate random() {
        var faker = FakerService.create().name();

        return new TypeDate(
            UUID.randomUUID(),
            new TypeDateName(faker.firstName())
        );
    }
}
