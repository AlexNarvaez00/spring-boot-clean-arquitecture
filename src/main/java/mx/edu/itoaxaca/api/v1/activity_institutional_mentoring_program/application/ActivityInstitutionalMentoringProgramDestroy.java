package mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain.ActivityInstitutionalMentoringProgramRepository;

public class ActivityInstitutionalMentoringProgramDestroy {
    public static void run(ActivityInstitutionalMentoringProgramRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
