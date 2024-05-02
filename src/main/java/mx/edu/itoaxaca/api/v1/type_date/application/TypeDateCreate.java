package mx.edu.itoaxaca.api.v1.type_date.application;

import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDate;
import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDateRepository;

public class TypeDateCreate {
    public static TypeDate run(TypeDateRepository repo, TypeDate arg) {
        return repo.save(arg);
    }
}
