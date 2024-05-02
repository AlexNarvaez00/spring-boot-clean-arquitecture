package mx.edu.itoaxaca.api.v1.type_date.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDate;
import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDateRepository;

public class TypeDateGetById {
    public static TypeDate run(TypeDateRepository repo, UUID id) {
        return repo.findTypeDateById(id);
    }
}
