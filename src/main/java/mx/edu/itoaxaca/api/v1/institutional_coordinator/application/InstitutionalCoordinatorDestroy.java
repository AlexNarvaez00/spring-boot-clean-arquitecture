package mx.edu.itoaxaca.api.v1.institutional_coordinator.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.institutional_coordinator.domain.InstitutionalCoordinatorRepository;

public class InstitutionalCoordinatorDestroy {
    public static void run(InstitutionalCoordinatorRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
