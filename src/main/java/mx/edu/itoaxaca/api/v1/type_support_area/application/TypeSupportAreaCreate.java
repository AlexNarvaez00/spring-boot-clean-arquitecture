package mx.edu.itoaxaca.api.v1.type_support_area.application;

import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportArea;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaRepository;

public class TypeSupportAreaCreate {

    public static void run(
        TypeSupportAreaRepository repo,
        TypeSupportArea arg
    ) {
        repo.save(arg);
    }
}
