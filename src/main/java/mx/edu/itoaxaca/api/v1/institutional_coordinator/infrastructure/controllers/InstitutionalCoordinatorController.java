package mx.edu.itoaxaca.api.v1.institutional_coordinator.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.institutional_coordinator.application.InstitutionalCoordinatorCreate;
import mx.edu.itoaxaca.api.v1.institutional_coordinator.application.InstitutionalCoordinatorDestroy;
import mx.edu.itoaxaca.api.v1.institutional_coordinator.application.InstitutionalCoordinatorGetAll;
import mx.edu.itoaxaca.api.v1.institutional_coordinator.application.InstitutionalCoordinatorGetById;
import mx.edu.itoaxaca.api.v1.institutional_coordinator.application.InstitutionalCoordinatorUpdate;
import mx.edu.itoaxaca.api.v1.institutional_coordinator.domain.InstitutionalCoordinator;
import mx.edu.itoaxaca.api.v1.institutional_coordinator.domain.InstitutionalCoordinatorRepository;
import mx.edu.itoaxaca.api.v1.institutional_coordinator.domain.InstitutionalCoordinatorStoreRequest;
import mx.edu.itoaxaca.api.v1.institutional_coordinator.domain.InstitutionalCoordinatorUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Routes.API_V1_INSTITUCIONAL_COORDINATOR_BASE)
@RequiredArgsConstructor
public class InstitutionalCoordinatorController {
    private final InstitutionalCoordinatorRepository repo;

    @GetMapping
    Page<InstitutionalCoordinator> index() {
        return InstitutionalCoordinatorGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    InstitutionalCoordinator show(@PathVariable UUID id) {
        return InstitutionalCoordinatorGetById.run(repo, id);
    }

    @PostMapping
    InstitutionalCoordinator store(@Valid @RequestBody InstitutionalCoordinatorStoreRequest request) {
        return InstitutionalCoordinatorCreate.run(repo, request.asInstitutionalCoordinator());
    }

    @PutMapping(value = "/{id}")
    InstitutionalCoordinator update(
        @PathVariable UUID id,
        @Valid @RequestBody InstitutionalCoordinatorUpdateRequest request
    ) {
        return InstitutionalCoordinatorUpdate.run(repo, id, request.asInstitutionalCoordinator());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        InstitutionalCoordinatorDestroy.run(repo, id);
    }
}
