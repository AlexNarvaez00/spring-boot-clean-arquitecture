package mx.edu.itoaxaca.api.v1.institutional_coordinator.application;

import mx.edu.itoaxaca.api.v1.institutional_coordinator.domain.InstitutionalCoordinator;
import mx.edu.itoaxaca.api.v1.institutional_coordinator.domain.InstitutionalCoordinatorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class InstitutionalCoordinatorGetAll {
    public static Page<InstitutionalCoordinator> run(Pageable pageable, InstitutionalCoordinatorRepository repo) {
        return repo.findAll(pageable);
    }
}
