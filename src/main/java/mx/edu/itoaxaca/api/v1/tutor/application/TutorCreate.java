package mx.edu.itoaxaca.api.v1.tutor.application;

import mx.edu.itoaxaca.api.v1.tutor.domain.Tutor;
import mx.edu.itoaxaca.api.v1.tutor.domain.TutorRepository;

public class TutorCreate {
    public static Tutor run(TutorRepository repo, Tutor arg) {
        return repo.save(arg);
    }
}
