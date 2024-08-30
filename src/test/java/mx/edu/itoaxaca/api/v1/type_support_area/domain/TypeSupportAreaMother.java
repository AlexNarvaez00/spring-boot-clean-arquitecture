package mx.edu.itoaxaca.api.v1.type_support_area.domain;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.FakerService;
import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.PostgresTypeSupportArea;

public class TypeSupportAreaMother {

    public static PostgresTypeSupportArea random() {
        return new PostgresTypeSupportArea(
            UUID.randomUUID(),
            new TypeSupportAreaType(FakerService.create().name().firstName())
        );
    }
}
