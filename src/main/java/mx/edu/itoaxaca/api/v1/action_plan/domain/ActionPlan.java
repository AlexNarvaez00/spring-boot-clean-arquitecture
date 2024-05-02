package mx.edu.itoaxaca.api.v1.action_plan.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "action_plans")
@NoArgsConstructor
public class ActionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "code", nullable = false)
    @Convert(converter = ActionPlanCodeConverter.class)
    private ActionPlanCode code;

    public ActionPlan(UUID id, ActionPlanCode code) {
        this.id = id;
        this.code = code;
    }
}
