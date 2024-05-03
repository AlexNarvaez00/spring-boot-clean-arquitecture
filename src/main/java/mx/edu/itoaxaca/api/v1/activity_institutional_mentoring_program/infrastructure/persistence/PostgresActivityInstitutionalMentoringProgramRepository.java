package mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain.ActivityInstitutionalMentoringProgram;
import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain.ActivityInstitutionalMentoringProgramRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresActivityInstitutionalMentoringProgramRepository 
    extends JpaRepository<ActivityInstitutionalMentoringProgram, UUID>, ActivityInstitutionalMentoringProgramRepository {}
