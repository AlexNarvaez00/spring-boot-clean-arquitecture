package mx.edu.itoaxaca.api.v1.shedule.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.shedule.application.SheduleCreate;
import mx.edu.itoaxaca.api.v1.shedule.application.SheduleDestroy;
import mx.edu.itoaxaca.api.v1.shedule.application.SheduleGetAll;
import mx.edu.itoaxaca.api.v1.shedule.application.SheduleGetById;
import mx.edu.itoaxaca.api.v1.shedule.application.SheduleUpdate;
import mx.edu.itoaxaca.api.v1.shedule.domain.Shedule;
import mx.edu.itoaxaca.api.v1.shedule.domain.SheduleRepository;
import mx.edu.itoaxaca.api.v1.shedule.domain.SheduleStoreRequest;
import mx.edu.itoaxaca.api.v1.shedule.domain.SheduleUpdateRequest;
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
@RequestMapping(value = Routes.API_V1_SCHEDULE_BASE)
@RequiredArgsConstructor
public class SheduleController {
    private final SheduleRepository repo;

    @GetMapping
    Page<Shedule> index() {
        return SheduleGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    Shedule show(@PathVariable UUID id) {
        return SheduleGetById.run(repo, id);
    }

    @PostMapping
    Shedule store(@Valid @RequestBody SheduleStoreRequest request) {
        return SheduleCreate.run(repo, request.asShedule());
    }

    @PutMapping(value = "/{id}")
    Shedule update(
        @PathVariable UUID id,
        @Valid @RequestBody SheduleUpdateRequest request
    ) {
        return SheduleUpdate.run(repo, id, request.asShedule());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        SheduleDestroy.run(repo, id);
    }
}
