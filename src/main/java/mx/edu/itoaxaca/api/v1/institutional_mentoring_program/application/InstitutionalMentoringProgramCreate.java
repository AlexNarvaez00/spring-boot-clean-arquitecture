package mx.edu.itoaxaca.api.v1.institutional_mentoring_program.application;

import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain.InstitutionalMentoringProgram;
import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain.InstitutionalMentoringProgramRepository;

public class InstitutionalMentoringProgramCreate {
    public static InstitutionalMentoringProgram run(InstitutionalMentoringProgramRepository repo, InstitutionalMentoringProgram arg) {
        return repo.save(arg);
    }
}
