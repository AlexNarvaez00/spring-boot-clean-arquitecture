package mx.edu.itoaxaca.api.v1.shedule.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shedule.domain.SheduleRepository;

public class SheduleDestroy {
    public static void run(SheduleRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
