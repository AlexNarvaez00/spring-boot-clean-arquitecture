package mx.edu.itoaxaca.api.v1.activity.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.activity.domain.ActivityRepository;

public class ActivityDestroy {
    public static void run(ActivityRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
