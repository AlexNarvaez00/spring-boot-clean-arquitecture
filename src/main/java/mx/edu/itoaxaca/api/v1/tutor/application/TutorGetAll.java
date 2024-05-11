package mx.edu.itoaxaca.api.v1.tutor.application;

import mx.edu.itoaxaca.api.v1.tutor.domain.Tutor;
import mx.edu.itoaxaca.api.v1.tutor.domain.TutorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class TutorGetAll {
    public static Page<Tutor> run(Pageable pageable, TutorRepository repo) {
        return repo.findAll(pageable);
    }
}
