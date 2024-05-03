package mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain.ActivityInstitutionalMentoringProgram;
import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain.ActivityInstitutionalMentoringProgramRepository;

public class ActivityInstitutionalMentoringProgramUpdate {
    public static ActivityInstitutionalMentoringProgram run(
        ActivityInstitutionalMentoringProgramRepository repo,
        UUID id,
        ActivityInstitutionalMentoringProgram arg
    ) {
        arg.setId(id);
        return repo.save(arg);
    }
}
