package mx.edu.itoaxaca.api.v1.type_support_area.domain;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.FakerService;

public class TypeSupportAreaMother {

    public static TypeSupportArea random() {
        return new TypeSupportArea(
            UUID.randomUUID(),
            new TypeSupportAreaType(FakerService.create().name().firstName())
        );
    }
}
