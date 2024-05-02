package mx.edu.itoaxaca.api.v1.date.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.date.domain.Date;
import mx.edu.itoaxaca.api.v1.date.domain.DateRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresDateRepository 
    extends JpaRepository<Date, UUID>, DateRepository {}
