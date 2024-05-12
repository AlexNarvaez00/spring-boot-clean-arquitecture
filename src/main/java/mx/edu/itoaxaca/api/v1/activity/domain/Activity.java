package mx.edu.itoaxaca.api.v1.activity.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.itoaxaca.api.v1.action_plan.domain.ActionPlan;
import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain.ActivityInstitutionalMentoringProgram;
import mx.edu.itoaxaca.api.v1.annex.domain.Annex;

@Data
@Entity
@Table(name = "activities")
@NoArgsConstructor
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    @Convert(converter = ActivityNameConverter.class)
    private ActivityName name;

    @ManyToOne
    @JoinColumn(name = "action_plan_id", nullable = false)
    @JsonIgnore
    private ActionPlan actionPlan;

    @ManyToOne
    @JoinColumn(name = "activity_institutional_mentoring_program_id")
    @JsonIgnore
    private ActivityInstitutionalMentoringProgram activityInstitutionalMentoringProgram;

    @ManyToOne
    @JoinColumn(name = "annex_id")
    @JsonIgnore
    private Annex annex;

    public Activity(
        UUID id,
        ActivityName name,
        ActionPlan actionPlan,
        ActivityInstitutionalMentoringProgram activityInstitutionalMentoringProgram,
        Annex annex
    ) {
        this.id = id;
        this.name = name;
        this.actionPlan = actionPlan;
        this.activityInstitutionalMentoringProgram =
            activityInstitutionalMentoringProgram;
        this.annex = annex;
    }
}
