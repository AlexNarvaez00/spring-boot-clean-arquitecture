package mx.edu.itoaxaca.api.v1.speciality.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.speciality.domain.SpecialityRepository;

public class SpecialityDestroy {
    public static void run(SpecialityRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
