package mx.edu.itoaxaca.api.v1.institutional_mentoring_program.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain.InstitutionalMentoringProgram;
import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain.InstitutionalMentoringProgramRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresInstitutionalMentoringProgramRepository 
    extends JpaRepository<InstitutionalMentoringProgram, UUID>, InstitutionalMentoringProgramRepository {}
