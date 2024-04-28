package mx.edu.itoaxaca.api.v1.type_support_area.application;

import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportArea;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaRepository;

public class TypeSupportAreaCreate {
    public static TypeSupportArea run(TypeSupportAreaRepository repo, TypeSupportArea arg) {
        return repo.save(arg);
    }
}
