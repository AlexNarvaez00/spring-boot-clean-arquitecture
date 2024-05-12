package mx.edu.itoaxaca.api.v1.channeling.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.channeling.domain.Channelling;
import mx.edu.itoaxaca.api.v1.channeling.domain.ChannellingRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresChannellingRepository 
    extends JpaRepository<Channelling, UUID>, ChannellingRepository {}
