package mx.edu.itoaxaca.api.v1.institutional_coordinator.application;

import mx.edu.itoaxaca.api.v1.institutional_coordinator.domain.InstitutionalCoordinator;
import mx.edu.itoaxaca.api.v1.institutional_coordinator.domain.InstitutionalCoordinatorRepository;

public class InstitutionalCoordinatorCreate {
    public static InstitutionalCoordinator run(InstitutionalCoordinatorRepository repo, InstitutionalCoordinator arg) {
        return repo.save(arg);
    }
}
