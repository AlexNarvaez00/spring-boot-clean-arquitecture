package mx.edu.itoaxaca.api.v1.date_profile.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.date_profile.domain.DateProfile;
import mx.edu.itoaxaca.api.v1.date_profile.domain.DateProfileRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresDateProfileRepository 
    extends JpaRepository<DateProfile, UUID>, DateProfileRepository {}
