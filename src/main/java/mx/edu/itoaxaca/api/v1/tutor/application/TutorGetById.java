package mx.edu.itoaxaca.api.v1.tutor.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.tutor.domain.Tutor;
import mx.edu.itoaxaca.api.v1.tutor.domain.TutorRepository;

public class TutorGetById {
    public static Tutor run(TutorRepository repo, UUID id) {
        return repo.findTutorById(id);
    }
}
