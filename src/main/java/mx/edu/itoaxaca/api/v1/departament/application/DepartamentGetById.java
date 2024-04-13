package mx.edu.itoaxaca.api.v1.departament.application;

import java.util.UUID;

import mx.edu.itoaxaca.api.v1.departament.domain.Departament;
import mx.edu.itoaxaca.api.v1.departament.domain.DepartamentRepository;

public class DepartamentGetById {
    public static Departament run(DepartamentRepository repository, UUID id){
        return repository.findDepartamentById(id);
    }
}
