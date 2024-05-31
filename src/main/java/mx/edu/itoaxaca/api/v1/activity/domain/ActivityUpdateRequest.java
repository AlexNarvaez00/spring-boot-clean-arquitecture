package mx.edu.itoaxaca.api.v1.activity.domain;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.action_plan.domain.ActionPlan;
import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain.ActivityInstitutionalMentoringProgram;
import mx.edu.itoaxaca.api.v1.annex.domain.Annex;

@Setter
public class ActivityUpdateRequest {

    @NotNull
    private String name;

    @NotNull
    private UUID action_plan_id;

    @NotNull
    private UUID activity_institutional_mentoring_program_id;
    
    @NotNull
    private UUID annex_id;
    
    public Activity asActivity() {
        return new Activity(
            null,
            new ActivityName(this.name),
            new ActionPlan(this.action_plan_id, null),
            new ActivityInstitutionalMentoringProgram(this.action_plan_id, null, null),
            new Annex(annex_id, null, null)
        );
    }
}
