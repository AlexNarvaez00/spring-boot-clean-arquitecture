package mx.edu.itoaxaca.api.v1.departamental_coordinator.application;

import mx.edu.itoaxaca.api.v1.departamental_coordinator.domain.DepartamentalCoordinator;
import mx.edu.itoaxaca.api.v1.departamental_coordinator.domain.DepartamentalCoordinatorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class DepartamentalCoordinatorGetAll {
    public static Page<DepartamentalCoordinator> run(Pageable pageable, DepartamentalCoordinatorRepository repo) {
        return repo.findAll(pageable);
    }
}
