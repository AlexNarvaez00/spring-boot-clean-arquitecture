package mx.edu.itoaxaca.api.v1.departament.application;

import mx.edu.itoaxaca.api.v1.departament.domain.Departament;
import mx.edu.itoaxaca.api.v1.departament.domain.DepartamentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class DepartamentGetAll {

    public static Page<Departament> run(Pageable pageable, DepartamentRepository repository) {
        return repository.findAll(pageable);
    }
}
