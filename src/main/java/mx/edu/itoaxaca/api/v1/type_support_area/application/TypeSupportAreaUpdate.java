package mx.edu.itoaxaca.api.v1.type_support_area.application;

import java.util.UUID;

import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportArea;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaRepository;

public class TypeSupportAreaUpdate {
    public static TypeSupportArea run(
        TypeSupportAreaRepository repo,
        UUID id,
        TypeSupportArea arg
    ) {
        return repo.save(arg);
    }
}
