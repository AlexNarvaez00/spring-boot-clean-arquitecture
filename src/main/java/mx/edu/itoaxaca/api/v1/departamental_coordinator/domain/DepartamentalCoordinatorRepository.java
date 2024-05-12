package mx.edu.itoaxaca.api.v1.departamental_coordinator.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartamentalCoordinatorRepository {
    DepartamentalCoordinator save(DepartamentalCoordinator arg);
    Page<DepartamentalCoordinator> findAll(Pageable pageable);
    void deleteById(UUID id);
    DepartamentalCoordinator findDepartamentalCoordinatorById(UUID id);
}
