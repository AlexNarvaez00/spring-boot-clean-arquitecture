package mx.edu.itoaxaca.api.v1.institutional_coordinator.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.institutional_coordinator.domain.InstitutionalCoordinator;
import mx.edu.itoaxaca.api.v1.institutional_coordinator.domain.InstitutionalCoordinatorRepository;

public class InstitutionalCoordinatorGetById {
    public static InstitutionalCoordinator run(InstitutionalCoordinatorRepository repo, UUID id) {
        return repo.findInstitutionalCoordinatorById(id);
    }
}
