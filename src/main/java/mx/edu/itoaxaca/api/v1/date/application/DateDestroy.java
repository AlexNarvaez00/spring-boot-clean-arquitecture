package mx.edu.itoaxaca.api.v1.date.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.date.domain.DateRepository;

public class DateDestroy {
    public static void run(DateRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
