package mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InstitutionalMentoringProgramRepository {
    InstitutionalMentoringProgram save(InstitutionalMentoringProgram arg);
    Page<InstitutionalMentoringProgram> findAll(Pageable pageable);
    void deleteById(UUID id);
    InstitutionalMentoringProgram findInstitutionalMentoringProgramById(UUID id);
}
