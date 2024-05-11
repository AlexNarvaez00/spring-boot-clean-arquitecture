package mx.edu.itoaxaca.api.v1.institutional_coordinator.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.institutional_coordinator.domain.InstitutionalCoordinator;
import mx.edu.itoaxaca.api.v1.institutional_coordinator.domain.InstitutionalCoordinatorRepository;

public class InstitutionalCoordinatorUpdate {
    public static InstitutionalCoordinator run(
        InstitutionalCoordinatorRepository repo,
        UUID id,
        InstitutionalCoordinator arg
    ) {
        arg.setId(id);
        return repo.save(arg);
    }
}
