package mx.edu.itoaxaca.api.v1.institutional_mentoring_program.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain.InstitutionalMentoringProgram;
import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain.InstitutionalMentoringProgramRepository;

public class InstitutionalMentoringProgramUpdate {
    public static InstitutionalMentoringProgram run(
        InstitutionalMentoringProgramRepository repo,
        UUID id,
        InstitutionalMentoringProgram arg
    ) {
        arg.setId(id);
        return repo.save(arg);
    }
}
