package mx.edu.itoaxaca.api.v1.type_support_area.application;

import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaPrimitives;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class TypeSupportAreaGetAll {

    public static Page<TypeSupportAreaPrimitives> run(
        Pageable pageable,
        TypeSupportAreaRepository repo
    ) {
        return repo
            .findAll(pageable)
            .map(typeSupportArea -> {
                return typeSupportArea.toPrimitives();
            });
    }
}
