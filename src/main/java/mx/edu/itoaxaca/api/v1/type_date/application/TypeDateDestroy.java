package mx.edu.itoaxaca.api.v1.type_date.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDateRepository;

public class TypeDateDestroy {
    public static void run(TypeDateRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
