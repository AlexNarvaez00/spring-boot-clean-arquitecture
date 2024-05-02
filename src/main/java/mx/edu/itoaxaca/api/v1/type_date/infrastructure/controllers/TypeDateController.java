package mx.edu.itoaxaca.api.v1.type_date.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.type_date.application.TypeDateCreate;
import mx.edu.itoaxaca.api.v1.type_date.application.TypeDateDestroy;
import mx.edu.itoaxaca.api.v1.type_date.application.TypeDateGetAll;
import mx.edu.itoaxaca.api.v1.type_date.application.TypeDateGetById;
import mx.edu.itoaxaca.api.v1.type_date.application.TypeDateUpdate;
import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDate;
import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDateRepository;
import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDateStoreRequest;
import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDateUpdateRequest;
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
@RequestMapping(value = Routes.API_V1_TYPE_DATE_BASE)
@RequiredArgsConstructor
public class TypeDateController {

    private final TypeDateRepository repo;

    @GetMapping
    Page<TypeDate> index() {
        return TypeDateGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    TypeDate show(@PathVariable UUID id) {
        return TypeDateGetById.run(repo, id);
    }

    @PostMapping
    TypeDate store(@Valid @RequestBody TypeDateStoreRequest request) {
        return TypeDateCreate.run(repo, request.asTypeDate());
    }

    @PutMapping(value = "/{id}")
    TypeDate update(
        @PathVariable UUID id,
        @Valid @RequestBody TypeDateUpdateRequest request
    ) {
        return TypeDateUpdate.run(repo, id, request.asTypeDate());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        TypeDateDestroy.run(repo, id);
    }
}
