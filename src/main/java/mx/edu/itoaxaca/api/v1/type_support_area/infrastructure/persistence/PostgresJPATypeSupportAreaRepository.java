package mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresJPATypeSupportAreaRepository 
    extends JpaRepository<PostgresTypeSupportArea, UUID> {}
