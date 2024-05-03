package mx.edu.itoaxaca.api.v1.institutional_mentoring_program.application;

import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain.InstitutionalMentoringProgram;
import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain.InstitutionalMentoringProgramRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class InstitutionalMentoringProgramGetAll {
    public static Page<InstitutionalMentoringProgram> run(Pageable pageable, InstitutionalMentoringProgramRepository repo) {
        return repo.findAll(pageable);
    }
}
