package mx.edu.itoaxaca.api.v1.departamental_coordinator.application;

import mx.edu.itoaxaca.api.v1.departamental_coordinator.domain.DepartamentalCoordinator;
import mx.edu.itoaxaca.api.v1.departamental_coordinator.domain.DepartamentalCoordinatorRepository;

public class DepartamentalCoordinatorCreate {
    public static DepartamentalCoordinator run(DepartamentalCoordinatorRepository repo, DepartamentalCoordinator arg) {
        return repo.save(arg);
    }
}
