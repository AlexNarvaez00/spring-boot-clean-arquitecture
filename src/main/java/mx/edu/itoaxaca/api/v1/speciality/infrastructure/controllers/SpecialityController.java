package mx.edu.itoaxaca.api.v1.speciality.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.speciality.application.SpecialityCreate;
import mx.edu.itoaxaca.api.v1.speciality.application.SpecialityDestroy;
import mx.edu.itoaxaca.api.v1.speciality.application.SpecialityGetAll;
import mx.edu.itoaxaca.api.v1.speciality.application.SpecialityGetById;
import mx.edu.itoaxaca.api.v1.speciality.application.SpecialityUpdate;
import mx.edu.itoaxaca.api.v1.speciality.domain.Speciality;
import mx.edu.itoaxaca.api.v1.speciality.domain.SpecialityRepository;
import mx.edu.itoaxaca.api.v1.speciality.domain.SpecialityStoreRequest;
import mx.edu.itoaxaca.api.v1.speciality.domain.SpecialityUpdateRequest;
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
@RequestMapping(value = Routes.API_V1_SPECIALITY_BASE)
@RequiredArgsConstructor
public class SpecialityController {
    private final SpecialityRepository repo;

    @GetMapping
    Page<Speciality> index() {
        return SpecialityGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    Speciality show(@PathVariable UUID id) {
        return SpecialityGetById.run(repo, id);
    }

    @PostMapping
    Speciality store(@Valid @RequestBody SpecialityStoreRequest request) {
        return SpecialityCreate.run(repo, request.asSpeciality());
    }

    @PutMapping(value = "/{id}")
    Speciality update(
        @PathVariable UUID id,
        @Valid @RequestBody SpecialityUpdateRequest request
    ) {
        return SpecialityUpdate.run(repo, id, request.asSpeciality());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        SpecialityDestroy.run(repo, id);
    }
}
