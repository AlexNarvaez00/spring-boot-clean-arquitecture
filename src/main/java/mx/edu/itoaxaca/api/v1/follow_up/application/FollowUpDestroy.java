package mx.edu.itoaxaca.api.v1.follow_up.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.follow_up.domain.FollowUpRepository;

public class FollowUpDestroy {
    public static void run(FollowUpRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
