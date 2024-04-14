package mx.edu.itoaxaca.api.v1.syllabus.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SyllabusRepository {
    Syllabus save(Syllabus syllabus);
    Page<Syllabus> findAll(Pageable pageable);
    void deleteById(UUID id);
    Syllabus findSyllabusById(UUID id);
}
