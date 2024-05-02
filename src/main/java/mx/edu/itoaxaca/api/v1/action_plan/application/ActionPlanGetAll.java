package mx.edu.itoaxaca.api.v1.action_plan.application;

import mx.edu.itoaxaca.api.v1.action_plan.domain.ActionPlan;
import mx.edu.itoaxaca.api.v1.action_plan.domain.ActionPlanRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ActionPlanGetAll {
    public static Page<ActionPlan> run(Pageable pageable, ActionPlanRepository repo) {
        return repo.findAll(pageable);
    }
}
