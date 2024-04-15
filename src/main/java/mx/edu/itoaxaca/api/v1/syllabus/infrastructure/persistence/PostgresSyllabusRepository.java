package mx.edu.itoaxaca.api.v1.syllabus.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.syllabus.domain.Syllabus;
import mx.edu.itoaxaca.api.v1.syllabus.domain.SyllabusRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresSyllabusRepository
    extends JpaRepository<Syllabus, UUID>, SyllabusRepository {}
