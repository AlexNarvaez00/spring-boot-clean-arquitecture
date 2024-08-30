package mx.edu.itoaxaca.api.v1.type_support_area.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.PostgresTypeSupportArea;

public interface TypeSupportAreaRepository {
    PostgresTypeSupportArea save(PostgresTypeSupportArea arg);
    Page<PostgresTypeSupportArea> findAll(Pageable pageable);
    void deleteById(UUID id);
    PostgresTypeSupportArea findTypeSupportAreaById(UUID id);
}
