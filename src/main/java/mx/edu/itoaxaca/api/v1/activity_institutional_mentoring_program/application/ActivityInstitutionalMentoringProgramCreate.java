package mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.application;

import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain.ActivityInstitutionalMentoringProgram;
import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain.ActivityInstitutionalMentoringProgramRepository;

public class ActivityInstitutionalMentoringProgramCreate {
    public static ActivityInstitutionalMentoringProgram run(ActivityInstitutionalMentoringProgramRepository repo, ActivityInstitutionalMentoringProgram arg) {
        return repo.save(arg);
    }
}
