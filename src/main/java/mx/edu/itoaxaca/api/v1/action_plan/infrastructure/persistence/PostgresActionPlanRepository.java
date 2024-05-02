package mx.edu.itoaxaca.api.v1.action_plan.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.action_plan.domain.ActionPlan;
import mx.edu.itoaxaca.api.v1.action_plan.domain.ActionPlanRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresActionPlanRepository 
    extends JpaRepository<ActionPlan, UUID>, ActionPlanRepository {}
