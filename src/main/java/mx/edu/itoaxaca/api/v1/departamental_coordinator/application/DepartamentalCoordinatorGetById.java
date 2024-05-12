package mx.edu.itoaxaca.api.v1.departamental_coordinator.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.departamental_coordinator.domain.DepartamentalCoordinator;
import mx.edu.itoaxaca.api.v1.departamental_coordinator.domain.DepartamentalCoordinatorRepository;

public class DepartamentalCoordinatorGetById {
    public static DepartamentalCoordinator run(DepartamentalCoordinatorRepository repo, UUID id) {
        return repo.findDepartamentalCoordinatorById(id);
    }
}
