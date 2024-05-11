package mx.edu.itoaxaca.api.v1.tutor.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.tutor.domain.TutorRepository;

public class TutorDestroy {
    public static void run(TutorRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
