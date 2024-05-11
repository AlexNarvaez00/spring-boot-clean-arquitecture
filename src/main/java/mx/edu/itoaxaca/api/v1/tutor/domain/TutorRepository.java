package mx.edu.itoaxaca.api.v1.tutor.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TutorRepository {
    Tutor save(Tutor arg);
    Tutor saveAndFlush(Tutor arg);
    Page<Tutor> findAll(Pageable pageable);
    void deleteById(UUID id);
    Tutor findTutorById(UUID id);
}
