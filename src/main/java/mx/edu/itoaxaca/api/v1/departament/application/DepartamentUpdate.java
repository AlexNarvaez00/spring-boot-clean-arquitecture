package mx.edu.itoaxaca.api.v1.departament.application;

import mx.edu.itoaxaca.api.v1.departament.domain.Departament;
import mx.edu.itoaxaca.api.v1.departament.domain.DepartamentRepository;

public class DepartamentUpdate {

    public static Departament run(DepartamentRepository repository, Departament departament) {
        return repository.save(departament);
    }
}
