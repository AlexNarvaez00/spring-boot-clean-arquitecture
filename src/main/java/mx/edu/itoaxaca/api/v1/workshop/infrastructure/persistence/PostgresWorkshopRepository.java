package mx.edu.itoaxaca.api.v1.workshop.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.workshop.domain.Workshop;
import mx.edu.itoaxaca.api.v1.workshop.domain.WorkshopRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresWorkshopRepository
    extends JpaRepository<Workshop, UUID>, WorkshopRepository {}
