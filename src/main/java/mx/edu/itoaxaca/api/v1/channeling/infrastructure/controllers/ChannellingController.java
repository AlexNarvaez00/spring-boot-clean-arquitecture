package mx.edu.itoaxaca.api.v1.channeling.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.channeling.application.ChannellingCreate;
import mx.edu.itoaxaca.api.v1.channeling.application.ChannellingDestroy;
import mx.edu.itoaxaca.api.v1.channeling.application.ChannellingGetAll;
import mx.edu.itoaxaca.api.v1.channeling.application.ChannellingGetById;
import mx.edu.itoaxaca.api.v1.channeling.application.ChannellingUpdate;
import mx.edu.itoaxaca.api.v1.channeling.domain.Channelling;
import mx.edu.itoaxaca.api.v1.channeling.domain.ChannellingRepository;
import mx.edu.itoaxaca.api.v1.channeling.domain.ChannellingStoreRequest;
import mx.edu.itoaxaca.api.v1.channeling.domain.ChannellingUpdateRequest;
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
@RequestMapping(value = Routes.API_V1_CHANNELING_BASE)
@RequiredArgsConstructor
public class ChannellingController {
    private final ChannellingRepository repo;

    @GetMapping
    Page<Channelling> index() {
        return ChannellingGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    Channelling show(@PathVariable UUID id) {
        return ChannellingGetById.run(repo, id);
    }

    @PostMapping
    Channelling store(@Valid @RequestBody ChannellingStoreRequest request) {
        return ChannellingCreate.run(repo, request.asChannelling());
    }

    @PutMapping(value = "/{id}")
    Channelling update(
        @PathVariable UUID id,
        @Valid @RequestBody ChannellingUpdateRequest request
    ) {
        return ChannellingUpdate.run(repo, id, request.asChannelling());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        ChannellingDestroy.run(repo, id);
    }
}
