package mx.edu.itoaxaca.api.v1.type_support_area.application;

import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportArea;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class TypeSupportAreaGetAll {
    public static Page<TypeSupportArea> run(Pageable pageable, TypeSupportAreaRepository repo) {
        return repo.findAll(pageable);
    }
}
