package mx.edu.itoaxaca.api.v1.follow_up.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.follow_up.domain.FollowUp;
import mx.edu.itoaxaca.api.v1.follow_up.domain.FollowUpRepository;

public class FollowUpGetById {
    public static FollowUp run(FollowUpRepository repo, UUID id) {
        return repo.findFollowUpById(id);
    }
}
