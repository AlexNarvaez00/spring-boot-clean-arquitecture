package mx.edu.itoaxaca.api.v1.date_profile.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.date_profile.domain.DateProfileRepository;

public class DateProfileDestroy {
    public static void run(DateProfileRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
