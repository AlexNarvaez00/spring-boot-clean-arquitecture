package mx.edu.itoaxaca.api.v1.type_support_area.application;

import java.util.List;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaPrimitives;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaRepository;

public class TypeSupportAreaGetAll {

    public static List<TypeSupportAreaPrimitives> run(
        TypeSupportAreaRepository repo
    ) {
        return repo
            .findAll()
            .stream()
            .map(typeSupportArea -> {
                return typeSupportArea.toPrimitives();
            })
            .toList();
    }
}
