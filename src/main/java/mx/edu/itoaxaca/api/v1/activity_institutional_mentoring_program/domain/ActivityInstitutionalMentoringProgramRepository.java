package mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ActivityInstitutionalMentoringProgramRepository {
    ActivityInstitutionalMentoringProgram save(ActivityInstitutionalMentoringProgram arg);
    Page<ActivityInstitutionalMentoringProgram> findAll(Pageable pageable);
    void deleteById(UUID id);
    ActivityInstitutionalMentoringProgram findActivityInstitutionalMentoringProgramById(UUID id);
}
