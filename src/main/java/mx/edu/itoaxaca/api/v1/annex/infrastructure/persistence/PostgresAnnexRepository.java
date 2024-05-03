package mx.edu.itoaxaca.api.v1.annex.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.annex.domain.Annex;
import mx.edu.itoaxaca.api.v1.annex.domain.AnnexRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresAnnexRepository 
    extends JpaRepository<Annex, UUID>, AnnexRepository {}
