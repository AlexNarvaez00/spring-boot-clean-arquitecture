package mx.edu.itoaxaca.api.v1.action_plan.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ActionPlanRepository {
    ActionPlan save(ActionPlan arg);
    Page<ActionPlan> findAll(Pageable pageable);
    void deleteById(UUID id);
    ActionPlan findActionPlanById(UUID id);
}
