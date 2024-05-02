package mx.edu.itoaxaca.api.v1.date.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.date.application.DateCreate;
import mx.edu.itoaxaca.api.v1.date.application.DateDestroy;
import mx.edu.itoaxaca.api.v1.date.application.DateGetAll;
import mx.edu.itoaxaca.api.v1.date.application.DateGetById;
import mx.edu.itoaxaca.api.v1.date.application.DateUpdate;
import mx.edu.itoaxaca.api.v1.date.domain.Date;
import mx.edu.itoaxaca.api.v1.date.domain.DateRepository;
import mx.edu.itoaxaca.api.v1.date.domain.DateStoreRequest;
import mx.edu.itoaxaca.api.v1.date.domain.DateUpdateRequest;
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
@RequestMapping(value = Routes.API_V1_DATE_BASE)
@RequiredArgsConstructor
public class DateController {

    private final DateRepository repo;

    @GetMapping
    Page<Date> index() {
        return DateGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    Date show(@PathVariable UUID id) {
        return DateGetById.run(repo, id);
    }

    @PostMapping
    Date store(@Valid @RequestBody DateStoreRequest request) {
        return DateCreate.run(repo, request.asDate());
    }

    @PutMapping(value = "/{id}")
    Date update(@PathVariable UUID id, @Valid @RequestBody DateUpdateRequest request) {
        return DateUpdate.run(repo, id, request.asDate());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        DateDestroy.run(repo, id);
    }
}
