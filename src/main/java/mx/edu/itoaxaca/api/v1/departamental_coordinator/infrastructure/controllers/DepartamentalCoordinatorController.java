package mx.edu.itoaxaca.api.v1.departamental_coordinator.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.departamental_coordinator.application.DepartamentalCoordinatorCreate;
import mx.edu.itoaxaca.api.v1.departamental_coordinator.application.DepartamentalCoordinatorDestroy;
import mx.edu.itoaxaca.api.v1.departamental_coordinator.application.DepartamentalCoordinatorGetAll;
import mx.edu.itoaxaca.api.v1.departamental_coordinator.application.DepartamentalCoordinatorGetById;
import mx.edu.itoaxaca.api.v1.departamental_coordinator.application.DepartamentalCoordinatorUpdate;
import mx.edu.itoaxaca.api.v1.departamental_coordinator.domain.DepartamentalCoordinator;
import mx.edu.itoaxaca.api.v1.departamental_coordinator.domain.DepartamentalCoordinatorRepository;
import mx.edu.itoaxaca.api.v1.departamental_coordinator.domain.DepartamentalCoordinatorStoreRequest;
import mx.edu.itoaxaca.api.v1.departamental_coordinator.domain.DepartamentalCoordinatorUpdateRequest;
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
@RequestMapping(value = Routes.API_V1_DEPARTAMENTAL_COORDINATOR_BASE)
@RequiredArgsConstructor
public class DepartamentalCoordinatorController {
    private final DepartamentalCoordinatorRepository repo;

    @GetMapping
    Page<DepartamentalCoordinator> index() {
        return DepartamentalCoordinatorGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    DepartamentalCoordinator show(@PathVariable UUID id) {
        return DepartamentalCoordinatorGetById.run(repo, id);
    }

    @PostMapping
    DepartamentalCoordinator store(@Valid @RequestBody DepartamentalCoordinatorStoreRequest request) {
        return DepartamentalCoordinatorCreate.run(repo, request.asDepartamentalCoordinator());
    }

    @PutMapping(value = "/{id}")
    DepartamentalCoordinator update(
        @PathVariable UUID id,
        @Valid @RequestBody DepartamentalCoordinatorUpdateRequest request
    ) {
        return DepartamentalCoordinatorUpdate.run(repo, id, request.asDepartamentalCoordinator());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        DepartamentalCoordinatorDestroy.run(repo, id);
    }
}
