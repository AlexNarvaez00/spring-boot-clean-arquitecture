package mx.edu.itoaxaca.api.v1.profile.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresProfileRepository 
    extends JpaRepository<Profile, UUID>, ProfileRepository {}
