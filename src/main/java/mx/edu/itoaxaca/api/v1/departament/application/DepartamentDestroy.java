package mx.edu.itoaxaca.api.v1.departament.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.departament.domain.DepartamentRepository;

public class DepartamentDestroy {

    public static void run(DepartamentRepository repository, UUID id) {
        repository.deleteById(id);
    }
}
