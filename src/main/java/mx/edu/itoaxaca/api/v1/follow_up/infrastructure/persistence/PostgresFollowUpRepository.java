package mx.edu.itoaxaca.api.v1.follow_up.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.follow_up.domain.FollowUp;
import mx.edu.itoaxaca.api.v1.follow_up.domain.FollowUpRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresFollowUpRepository 
    extends JpaRepository<FollowUp, UUID>, FollowUpRepository {}
