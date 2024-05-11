package mx.edu.itoaxaca.api.v1.tutor.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.tutor.domain.Tutor;
import mx.edu.itoaxaca.api.v1.tutor.domain.TutorRepository;

public class TutorUpdate {
    public static Tutor run(
        TutorRepository repo,
        UUID id,
        Tutor arg
    ) {
        arg.setId(id);
        return repo.save(arg);
    }
}
