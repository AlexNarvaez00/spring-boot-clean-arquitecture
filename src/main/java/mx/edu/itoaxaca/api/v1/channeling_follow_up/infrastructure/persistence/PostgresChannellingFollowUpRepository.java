package mx.edu.itoaxaca.api.v1.channeling_follow_up.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.channeling_follow_up.domain.ChannellingFollowUp;
import mx.edu.itoaxaca.api.v1.channeling_follow_up.domain.ChannellingFollowUpRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresChannellingFollowUpRepository 
    extends JpaRepository<ChannellingFollowUp, UUID>, ChannellingFollowUpRepository {}
