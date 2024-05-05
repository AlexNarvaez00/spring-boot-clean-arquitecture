package mx.edu.itoaxaca.api.v1.follow_up.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.follow_up.application.FollowUpCreate;
import mx.edu.itoaxaca.api.v1.follow_up.application.FollowUpDestroy;
import mx.edu.itoaxaca.api.v1.follow_up.application.FollowUpGetAll;
import mx.edu.itoaxaca.api.v1.follow_up.application.FollowUpGetById;
import mx.edu.itoaxaca.api.v1.follow_up.application.FollowUpUpdate;
import mx.edu.itoaxaca.api.v1.follow_up.domain.FollowUp;
import mx.edu.itoaxaca.api.v1.follow_up.domain.FollowUpRepository;
import mx.edu.itoaxaca.api.v1.follow_up.domain.FollowUpStoreRequest;
import mx.edu.itoaxaca.api.v1.follow_up.domain.FollowUpUpdateRequest;
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
@RequestMapping(value = Routes.API_V1_FOLLOW_UP_BASE)
@RequiredArgsConstructor
public class FollowUpController {
    private final FollowUpRepository repo;

    @GetMapping
    Page<FollowUp> index() {
        return FollowUpGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    FollowUp show(@PathVariable UUID id) {
        return FollowUpGetById.run(repo, id);
    }

    @PostMapping
    FollowUp store(@Valid @RequestBody FollowUpStoreRequest request) {
        return FollowUpCreate.run(repo, request.asFollowUp());
    }

    @PutMapping(value = "/{id}")
    FollowUp update(
        @PathVariable UUID id,
        @Valid @RequestBody FollowUpUpdateRequest request
    ) {
        return FollowUpUpdate.run(repo, id, request.asFollowUp());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        FollowUpDestroy.run(repo, id);
    }
}
