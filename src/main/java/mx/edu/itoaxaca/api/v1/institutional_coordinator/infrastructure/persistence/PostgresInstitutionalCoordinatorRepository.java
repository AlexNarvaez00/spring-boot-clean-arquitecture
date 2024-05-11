package mx.edu.itoaxaca.api.v1.institutional_coordinator.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.institutional_coordinator.domain.InstitutionalCoordinator;
import mx.edu.itoaxaca.api.v1.institutional_coordinator.domain.InstitutionalCoordinatorRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresInstitutionalCoordinatorRepository 
    extends JpaRepository<InstitutionalCoordinator, UUID>, InstitutionalCoordinatorRepository {}
