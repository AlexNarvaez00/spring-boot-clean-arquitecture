package mx.edu.itoaxaca.api.v1.action_plan.application;

import mx.edu.itoaxaca.api.v1.action_plan.domain.ActionPlan;
import mx.edu.itoaxaca.api.v1.action_plan.domain.ActionPlanRepository;

public class ActionPlanCreate {
    public static ActionPlan run(ActionPlanRepository repo, ActionPlan arg) {
        return repo.save(arg);
    }
}
