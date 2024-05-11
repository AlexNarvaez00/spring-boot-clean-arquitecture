package mx.edu.itoaxaca.api.v1.tutor.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.tutor.domain.Tutor;
import mx.edu.itoaxaca.api.v1.tutor.domain.TutorRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresTutorRepository 
    extends JpaRepository<Tutor, UUID>, TutorRepository {}
