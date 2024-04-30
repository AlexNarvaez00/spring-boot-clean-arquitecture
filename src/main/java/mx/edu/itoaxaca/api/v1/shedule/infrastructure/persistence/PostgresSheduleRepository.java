package mx.edu.itoaxaca.api.v1.shedule.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shedule.domain.Shedule;
import mx.edu.itoaxaca.api.v1.shedule.domain.SheduleRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresSheduleRepository 
    extends JpaRepository<Shedule, UUID>, SheduleRepository {}
