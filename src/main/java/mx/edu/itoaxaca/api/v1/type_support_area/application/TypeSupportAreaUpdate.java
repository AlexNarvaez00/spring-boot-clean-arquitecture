package mx.edu.itoaxaca.api.v1.type_support_area.application;

import java.util.UUID;

import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaRepository;
import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.PostgresTypeSupportArea;

public class TypeSupportAreaUpdate {
    public static PostgresTypeSupportArea run(
        TypeSupportAreaRepository repo,
        UUID id,
        PostgresTypeSupportArea arg
    ) {
        arg.setId(id);
        return repo.save(arg);
    }
}
