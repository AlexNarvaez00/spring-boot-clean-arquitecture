package mx.edu.itoaxaca.api.v1.action_plan.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.action_plan.application.ActionPlanCreate;
import mx.edu.itoaxaca.api.v1.action_plan.application.ActionPlanDestroy;
import mx.edu.itoaxaca.api.v1.action_plan.application.ActionPlanGetAll;
import mx.edu.itoaxaca.api.v1.action_plan.application.ActionPlanGetById;
import mx.edu.itoaxaca.api.v1.action_plan.application.ActionPlanUpdate;
import mx.edu.itoaxaca.api.v1.action_plan.domain.ActionPlan;
import mx.edu.itoaxaca.api.v1.action_plan.domain.ActionPlanRepository;
import mx.edu.itoaxaca.api.v1.action_plan.domain.ActionPlanStoreRequest;
import mx.edu.itoaxaca.api.v1.action_plan.domain.ActionPlanUpdateRequest;
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
@RequestMapping(value = Routes.API_V1_ACTION_PLAN_BASE)
@RequiredArgsConstructor
public class ActionPlanController {

    private final ActionPlanRepository repo;

    @GetMapping
    Page<ActionPlan> index() {
        return ActionPlanGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    ActionPlan show(@PathVariable UUID id) {
        return ActionPlanGetById.run(repo, id);
    }

    @PostMapping
    ActionPlan store(@Valid @RequestBody ActionPlanStoreRequest request) {
        return ActionPlanCreate.run(repo, request.asActionPlan());
    }

    @PutMapping(value = "/{id}")
    ActionPlan update(
        @PathVariable UUID id,
        @Valid @RequestBody ActionPlanUpdateRequest request
    ) {
        return ActionPlanUpdate.run(repo, id, request.asActionPlan());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        ActionPlanDestroy.run(repo, id);
    }
}
