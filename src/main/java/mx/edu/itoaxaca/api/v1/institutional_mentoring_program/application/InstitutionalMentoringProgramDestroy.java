package mx.edu.itoaxaca.api.v1.institutional_mentoring_program.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain.InstitutionalMentoringProgramRepository;

public class InstitutionalMentoringProgramDestroy {
    public static void run(InstitutionalMentoringProgramRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
