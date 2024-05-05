package mx.edu.itoaxaca.api.v1.period.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.period.application.PeriodCreate;
import mx.edu.itoaxaca.api.v1.period.application.PeriodDestroy;
import mx.edu.itoaxaca.api.v1.period.application.PeriodGetAll;
import mx.edu.itoaxaca.api.v1.period.application.PeriodGetById;
import mx.edu.itoaxaca.api.v1.period.application.PeriodUpdate;
import mx.edu.itoaxaca.api.v1.period.domain.Period;
import mx.edu.itoaxaca.api.v1.period.domain.PeriodRepository;
import mx.edu.itoaxaca.api.v1.period.domain.PeriodStoreRequest;
import mx.edu.itoaxaca.api.v1.period.domain.PeriodUpdateRequest;
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
@RequestMapping(value = Routes.API_V1_PERIOD_BASE)
@RequiredArgsConstructor
public class PeriodController {
    private final PeriodRepository repo;

    @GetMapping
    Page<Period> index() {
        return PeriodGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    Period show(@PathVariable UUID id) {
        return PeriodGetById.run(repo, id);
    }

    @PostMapping
    Period store(@Valid @RequestBody PeriodStoreRequest request) {
        return PeriodCreate.run(repo, request.asPeriod());
    }

    @PutMapping(value = "/{id}")
    Period update(
        @PathVariable UUID id,
        @Valid @RequestBody PeriodUpdateRequest request
    ) {
        return PeriodUpdate.run(repo, id, request.asPeriod());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        PeriodDestroy.run(repo, id);
    }
}
