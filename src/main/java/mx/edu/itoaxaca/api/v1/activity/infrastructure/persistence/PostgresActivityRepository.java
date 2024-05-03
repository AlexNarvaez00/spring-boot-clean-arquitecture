package mx.edu.itoaxaca.api.v1.activity.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.activity.domain.Activity;
import mx.edu.itoaxaca.api.v1.activity.domain.ActivityRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresActivityRepository 
    extends JpaRepository<Activity, UUID>, ActivityRepository {}
