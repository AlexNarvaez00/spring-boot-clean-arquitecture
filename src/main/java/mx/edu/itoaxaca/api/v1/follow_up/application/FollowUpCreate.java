package mx.edu.itoaxaca.api.v1.follow_up.application;

import mx.edu.itoaxaca.api.v1.follow_up.domain.FollowUp;
import mx.edu.itoaxaca.api.v1.follow_up.domain.FollowUpRepository;

public class FollowUpCreate {
    public static FollowUp run(FollowUpRepository repo, FollowUp arg) {
        return repo.save(arg);
    }
}
