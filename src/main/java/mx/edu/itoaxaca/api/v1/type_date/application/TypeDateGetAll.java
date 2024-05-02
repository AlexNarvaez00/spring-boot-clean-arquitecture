package mx.edu.itoaxaca.api.v1.type_date.application;

import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDate;
import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDateRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class TypeDateGetAll {
    public static Page<TypeDate> run(Pageable pageable, TypeDateRepository repo) {
        return repo.findAll(pageable);
    }
}
