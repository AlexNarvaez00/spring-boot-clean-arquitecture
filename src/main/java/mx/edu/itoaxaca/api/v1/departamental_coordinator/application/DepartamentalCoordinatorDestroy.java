package mx.edu.itoaxaca.api.v1.departamental_coordinator.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.departamental_coordinator.domain.DepartamentalCoordinatorRepository;

public class DepartamentalCoordinatorDestroy {
    public static void run(DepartamentalCoordinatorRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
