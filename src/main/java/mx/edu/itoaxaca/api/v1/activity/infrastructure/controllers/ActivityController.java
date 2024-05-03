package mx.edu.itoaxaca.api.v1.activity.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.activity.application.ActivityCreate;
import mx.edu.itoaxaca.api.v1.activity.application.ActivityDestroy;
import mx.edu.itoaxaca.api.v1.activity.application.ActivityGetAll;
import mx.edu.itoaxaca.api.v1.activity.application.ActivityGetById;
import mx.edu.itoaxaca.api.v1.activity.application.ActivityUpdate;
import mx.edu.itoaxaca.api.v1.activity.domain.Activity;
import mx.edu.itoaxaca.api.v1.activity.domain.ActivityRepository;
import mx.edu.itoaxaca.api.v1.activity.domain.ActivityStoreRequest;
import mx.edu.itoaxaca.api.v1.activity.domain.ActivityUpdateRequest;
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
@RequestMapping(value = Routes.API_V1_ACTIVITY_BASE)
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityRepository repo;

    @GetMapping
    Page<Activity> index() {
        return ActivityGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    Activity show(@PathVariable UUID id) {
        return ActivityGetById.run(repo, id);
    }

    @PostMapping
    Activity store(@Valid @RequestBody ActivityStoreRequest request) {
        return ActivityCreate.run(repo, request.asActivity());
    }

    @PutMapping(value = "/{id}")
    Activity update(
        @PathVariable UUID id,
        @Valid @RequestBody ActivityUpdateRequest request
    ) {
        return ActivityUpdate.run(repo, id, request.asActivity());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        ActivityDestroy.run(repo, id);
    }
}
