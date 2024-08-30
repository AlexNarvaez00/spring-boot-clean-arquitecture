package mx.edu.itoaxaca.api.v1.type_support_area.application;

import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaRepository;
import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.PostgresTypeSupportArea;

public class TypeSupportAreaCreate {
    public static PostgresTypeSupportArea run(TypeSupportAreaRepository repo, PostgresTypeSupportArea arg) {
        return repo.save(arg);
    }
}
