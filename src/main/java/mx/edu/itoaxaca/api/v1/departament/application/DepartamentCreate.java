package mx.edu.itoaxaca.api.v1.departament.application;

import io.micrometer.common.lang.NonNull;
import mx.edu.itoaxaca.api.v1.departament.domain.Departament;
import mx.edu.itoaxaca.api.v1.departament.domain.DepartamentRepository;

public class DepartamentCreate {

    public static Departament run(
        DepartamentRepository repository,
        @NonNull Departament departament
    ) {
        return null;
    }
}
