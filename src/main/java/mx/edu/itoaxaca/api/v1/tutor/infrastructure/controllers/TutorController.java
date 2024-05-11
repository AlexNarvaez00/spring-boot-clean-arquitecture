package mx.edu.itoaxaca.api.v1.tutor.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.tutor.application.TutorCreate;
import mx.edu.itoaxaca.api.v1.tutor.application.TutorDestroy;
import mx.edu.itoaxaca.api.v1.tutor.application.TutorGetAll;
import mx.edu.itoaxaca.api.v1.tutor.application.TutorGetById;
import mx.edu.itoaxaca.api.v1.tutor.application.TutorUpdate;
import mx.edu.itoaxaca.api.v1.tutor.domain.Tutor;
import mx.edu.itoaxaca.api.v1.tutor.domain.TutorRepository;
import mx.edu.itoaxaca.api.v1.tutor.domain.TutorStoreRequest;
import mx.edu.itoaxaca.api.v1.tutor.domain.TutorUpdateRequest;
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
@RequestMapping(value = Routes.API_V1_TUTOR_BASE)
@RequiredArgsConstructor
public class TutorController {
    private final TutorRepository repo;

    @GetMapping
    Page<Tutor> index() {
        return TutorGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    Tutor show(@PathVariable UUID id) {
        return TutorGetById.run(repo, id);
    }

    @PostMapping
    Tutor store(@Valid @RequestBody TutorStoreRequest request) {
        return TutorCreate.run(repo, request.asTutor());
    }

    @PutMapping(value = "/{id}")
    Tutor update(
        @PathVariable UUID id,
        @Valid @RequestBody TutorUpdateRequest request
    ) {
        return TutorUpdate.run(repo, id, request.asTutor());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        TutorDestroy.run(repo, id);
    }
}
