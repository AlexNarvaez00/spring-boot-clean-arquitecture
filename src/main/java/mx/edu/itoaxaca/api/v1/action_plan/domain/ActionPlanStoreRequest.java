package mx.edu.itoaxaca.api.v1.action_plan.domain;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Data;

@Data
public class ActionPlanStoreRequest {

    private UUID id;

    @NotNull
    private String name;

    public ActionPlan asActionPlan() {
        return new ActionPlan(
            (this.id == null) ? null : UUID.randomUUID(),
            new ActionPlanCode(this.name)
        );
    }
}
