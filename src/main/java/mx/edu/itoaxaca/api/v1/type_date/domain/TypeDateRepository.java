package mx.edu.itoaxaca.api.v1.type_date.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeDateRepository {
    TypeDate save(TypeDate arg);
    Page<TypeDate> findAll(Pageable pageable);
    void deleteById(UUID id);
    TypeDate findTypeDateById(UUID id);
}
