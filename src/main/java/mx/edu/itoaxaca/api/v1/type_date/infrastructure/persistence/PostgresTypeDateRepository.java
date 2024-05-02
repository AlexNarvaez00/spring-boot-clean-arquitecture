package mx.edu.itoaxaca.api.v1.type_date.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDate;
import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDateRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresTypeDateRepository 
    extends JpaRepository<TypeDate, UUID>, TypeDateRepository {}
