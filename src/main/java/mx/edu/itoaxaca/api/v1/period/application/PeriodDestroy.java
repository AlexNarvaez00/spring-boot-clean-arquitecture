package mx.edu.itoaxaca.api.v1.period.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.period.domain.PeriodRepository;

public class PeriodDestroy {
    public static void run(PeriodRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
