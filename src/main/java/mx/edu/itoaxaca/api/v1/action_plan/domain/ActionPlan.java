package mx.edu.itoaxaca.api.v1.action_plan.domain;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.itoaxaca.api.v1.career.domain.Career;

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

    @ManyToOne
    @JoinColumn(name = "career_id")
    @JsonIgnore
    private Career career;

    public ActionPlan(UUID id, ActionPlanCode code) {
        this.id = id;
        this.code = code;
    }
}
