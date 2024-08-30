package mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.type_support_area.application.TypeSupportAreaCreate;
import mx.edu.itoaxaca.api.v1.type_support_area.application.TypeSupportAreaDestroy;
import mx.edu.itoaxaca.api.v1.type_support_area.application.TypeSupportAreaGetAll;
import mx.edu.itoaxaca.api.v1.type_support_area.application.TypeSupportAreaGetById;
import mx.edu.itoaxaca.api.v1.type_support_area.application.TypeSupportAreaUpdate;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaRepository;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaStoreRequest;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaUpdateRequest;
import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.PostgresTypeSupportArea;

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
@RequestMapping(value = Routes.API_V1_TYPE_SUPPORT_AREAS_BASE)
@RequiredArgsConstructor
public class TypeSupportAreaController {

    private final TypeSupportAreaRepository repo;

    @GetMapping
    Page<PostgresTypeSupportArea> index() {
        return TypeSupportAreaGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    PostgresTypeSupportArea show(@PathVariable UUID id) {
        return TypeSupportAreaGetById.run(repo, id);
    }

    @PostMapping
    PostgresTypeSupportArea store(@Valid @RequestBody TypeSupportAreaStoreRequest request) {
        return TypeSupportAreaCreate.run(repo, request.asTypeSupportArea());
    }

    @PutMapping(value = "/{id}")
    PostgresTypeSupportArea update(
        @PathVariable UUID id,
        @Valid @RequestBody TypeSupportAreaUpdateRequest request
    ) {
        return TypeSupportAreaUpdate.run(repo, id, request.asTypeSupportArea());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        TypeSupportAreaDestroy.run(repo, id);
    }
}
