package mx.edu.itoaxaca.api.v1.action_plan.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.action_plan.domain.ActionPlanRepository;

public class ActionPlanDestroy {
    public static void run(ActionPlanRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
