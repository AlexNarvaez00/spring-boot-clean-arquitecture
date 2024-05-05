package mx.edu.itoaxaca.api.v1.period.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.period.domain.Period;
import mx.edu.itoaxaca.api.v1.period.domain.PeriodRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresPeriodRepository 
    extends JpaRepository<Period, UUID>, PeriodRepository {}
