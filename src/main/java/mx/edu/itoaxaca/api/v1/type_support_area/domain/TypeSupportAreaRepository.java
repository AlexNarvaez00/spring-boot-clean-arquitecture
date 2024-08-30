package mx.edu.itoaxaca.api.v1.type_support_area.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeSupportAreaRepository {
    TypeSupportArea save(TypeSupportArea arg);
    Page<TypeSupportArea> findAll(Pageable pageable);
    void deleteById(UUID id);
    TypeSupportArea findTypeSupportAreaById(UUID id);
}
