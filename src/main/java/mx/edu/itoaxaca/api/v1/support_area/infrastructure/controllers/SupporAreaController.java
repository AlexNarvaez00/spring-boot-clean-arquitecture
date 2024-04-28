package mx.edu.itoaxaca.api.v1.support_area.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.support_area.application.SupportAreaCreate;
import mx.edu.itoaxaca.api.v1.support_area.application.SupportAreaDestroy;
import mx.edu.itoaxaca.api.v1.support_area.application.SupportAreaGetAll;
import mx.edu.itoaxaca.api.v1.support_area.application.SupportAreaGetById;
import mx.edu.itoaxaca.api.v1.support_area.application.SupportAreaUpdate;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportArea;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportAreaRepository;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportAreaStoreRequest;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportAreaUpdateRequest;

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
@RequestMapping(value = Routes.API_V1_SUPPORT_AREAS_BASE)
@RequiredArgsConstructor
public class SupporAreaController {

    private final SupportAreaRepository repo;

    @GetMapping
    Page<SupportArea> index() {
        return SupportAreaGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    SupportArea show(@PathVariable UUID id) {
        return SupportAreaGetById.run(repo, id);
    }

    @PostMapping
    SupportArea store(@Valid @RequestBody SupportAreaStoreRequest request) {
        return SupportAreaCreate.run(repo, request.asSupportArea());
    }

    @PutMapping(value = "/{id}")
    SupportArea update(
        @PathVariable UUID id,
        @Valid @RequestBody SupportAreaUpdateRequest request
    ) {
        return SupportAreaUpdate.run(repo, id, request.asSupportArea());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        SupportAreaDestroy.run(repo, id);
    }
}
