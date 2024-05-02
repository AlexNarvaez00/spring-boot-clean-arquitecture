package mx.edu.itoaxaca.api.v1.action_plan.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActionPlanUpdateRequest {

    @NotNull
    private String name;

    public ActionPlan asActionPlan() {
        return new ActionPlan(null, new ActionPlanCode(this.name));
    }
}
