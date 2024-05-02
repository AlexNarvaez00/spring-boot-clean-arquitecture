package mx.edu.itoaxaca.api.v1.action_plan.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.action_plan.domain.ActionPlan;
import mx.edu.itoaxaca.api.v1.action_plan.domain.ActionPlanRepository;

public class ActionPlanGetById {
    public static ActionPlan run(ActionPlanRepository repo, UUID id) {
        return repo.findActionPlanById(id);
    }
}
