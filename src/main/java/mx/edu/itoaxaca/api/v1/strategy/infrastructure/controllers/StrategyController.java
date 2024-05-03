package mx.edu.itoaxaca.api.v1.strategy.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.strategy.application.StrategyCreate;
import mx.edu.itoaxaca.api.v1.strategy.application.StrategyDestroy;
import mx.edu.itoaxaca.api.v1.strategy.application.StrategyGetAll;
import mx.edu.itoaxaca.api.v1.strategy.application.StrategyGetById;
import mx.edu.itoaxaca.api.v1.strategy.application.StrategyUpdate;
import mx.edu.itoaxaca.api.v1.strategy.domain.Strategy;
import mx.edu.itoaxaca.api.v1.strategy.domain.StrategyRepository;
import mx.edu.itoaxaca.api.v1.strategy.domain.StrategyStoreRequest;
import mx.edu.itoaxaca.api.v1.strategy.domain.StrategyUpdateRequest;
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
@RequestMapping(value = Routes.API_V1_STRATEGY_BASE)
@RequiredArgsConstructor
public class StrategyController {
    private final StrategyRepository repo;

    @GetMapping
    Page<Strategy> index() {
        return StrategyGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    Strategy show(@PathVariable UUID id) {
        return StrategyGetById.run(repo, id);
    }

    @PostMapping
    Strategy store(@Valid @RequestBody StrategyStoreRequest request) {
        return StrategyCreate.run(repo, request.asStrategy());
    }

    @PutMapping(value = "/{id}")
    Strategy update(
        @PathVariable UUID id,
        @Valid @RequestBody StrategyUpdateRequest request
    ) {
        return StrategyUpdate.run(repo, id, request.asStrategy());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        StrategyDestroy.run(repo, id);
    }
}
