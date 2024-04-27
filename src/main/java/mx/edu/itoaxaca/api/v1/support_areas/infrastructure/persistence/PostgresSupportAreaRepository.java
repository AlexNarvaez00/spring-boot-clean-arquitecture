package mx.edu.itoaxaca.api.v1.support_areas.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.support_areas.domain.SupportArea;
import mx.edu.itoaxaca.api.v1.support_areas.domain.SupportAreaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresSupportAreaRepository
    extends JpaRepository<SupportArea, UUID>, SupportAreaRepository {}
