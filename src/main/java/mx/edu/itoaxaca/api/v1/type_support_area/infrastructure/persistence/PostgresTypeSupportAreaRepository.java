package mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportArea;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresTypeSupportAreaRepository 
    extends JpaRepository<TypeSupportArea, UUID>, TypeSupportAreaRepository {}
