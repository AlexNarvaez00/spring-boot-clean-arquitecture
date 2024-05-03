package mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.application;

import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain.ActivityInstitutionalMentoringProgram;
import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain.ActivityInstitutionalMentoringProgramRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ActivityInstitutionalMentoringProgramGetAll {
    public static Page<ActivityInstitutionalMentoringProgram> run(Pageable pageable, ActivityInstitutionalMentoringProgramRepository repo) {
        return repo.findAll(pageable);
    }
}
