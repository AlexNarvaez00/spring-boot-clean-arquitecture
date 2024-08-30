package mx.edu.itoaxaca.api.v1.type_support_area.application;

import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaRepository;
import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.PostgresTypeSupportArea;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class TypeSupportAreaGetAll {
    public static Page<PostgresTypeSupportArea> run(Pageable pageable, TypeSupportAreaRepository repo) {
        return repo.findAll(pageable);
    }
}
