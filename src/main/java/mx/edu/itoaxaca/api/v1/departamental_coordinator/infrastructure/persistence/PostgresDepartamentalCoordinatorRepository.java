package mx.edu.itoaxaca.api.v1.departamental_coordinator.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.departamental_coordinator.domain.DepartamentalCoordinator;
import mx.edu.itoaxaca.api.v1.departamental_coordinator.domain.DepartamentalCoordinatorRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresDepartamentalCoordinatorRepository 
    extends JpaRepository<DepartamentalCoordinator, UUID>, DepartamentalCoordinatorRepository {}
