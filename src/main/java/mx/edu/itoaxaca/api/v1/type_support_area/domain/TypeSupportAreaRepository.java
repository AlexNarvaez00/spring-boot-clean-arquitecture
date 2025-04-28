package mx.edu.itoaxaca.api.v1.type_support_area.domain;

import java.util.List;

public interface TypeSupportAreaRepository {
    void save(TypeSupportArea arg);
    List<TypeSupportArea> findAll();
}
