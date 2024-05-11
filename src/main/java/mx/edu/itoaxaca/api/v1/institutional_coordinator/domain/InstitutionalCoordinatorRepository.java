package mx.edu.itoaxaca.api.v1.institutional_coordinator.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InstitutionalCoordinatorRepository {
    InstitutionalCoordinator save(InstitutionalCoordinator arg);
    Page<InstitutionalCoordinator> findAll(Pageable pageable);
    void deleteById(UUID id);
    InstitutionalCoordinator findInstitutionalCoordinatorById(UUID id);
}
