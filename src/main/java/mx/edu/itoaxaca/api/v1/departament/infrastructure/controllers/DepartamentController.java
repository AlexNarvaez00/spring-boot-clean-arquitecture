package mx.edu.itoaxaca.api.v1.departament.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.departament.application.DepartamentCreate;
import mx.edu.itoaxaca.api.v1.departament.application.DepartamentDestroy;
import mx.edu.itoaxaca.api.v1.departament.application.DepartamentGetAll;
import mx.edu.itoaxaca.api.v1.departament.application.DepartamentGetById;
import mx.edu.itoaxaca.api.v1.departament.application.DepartamentUpdate;
import mx.edu.itoaxaca.api.v1.departament.domain.Departament;
import mx.edu.itoaxaca.api.v1.departament.domain.DepartamentRepository;
import mx.edu.itoaxaca.api.v1.departament.domain.DepartamentStoreRequest;
import mx.edu.itoaxaca.api.v1.departament.domain.DepartamentUpdateRequest;
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
@RequestMapping(value = Routes.API_V1_DEPARTAMENTE_BASE)
@RequiredArgsConstructor
public class DepartamentController {

    private final DepartamentRepository repository;

    @GetMapping(value = "")
    Page<Departament> index() {
        return DepartamentGetAll.run(PageRequest.of(0, 10), this.repository);
    }

    @GetMapping(value = "/{id}")
    Departament show(@PathVariable UUID id) {
        return DepartamentGetById.run(repository, id);
    }

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    Departament store(@Valid @RequestBody DepartamentStoreRequest request) {
        return DepartamentCreate.run(this.repository, request.asDepartament());
    }

    @PutMapping(value = Routes.API_V1_DEPARTAMENTE_UPDATE)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    Departament update(
        @PathVariable UUID id,
        @Valid @RequestBody DepartamentUpdateRequest request
    ) {
        return DepartamentUpdate.run(repository, request.asDepartament());
    }

    @DeleteMapping(value = Routes.API_V1_DEPARTAMENTE_DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        DepartamentDestroy.run(this.repository, id);
    }
}
