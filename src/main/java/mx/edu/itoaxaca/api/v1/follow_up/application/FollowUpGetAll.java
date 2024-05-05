package mx.edu.itoaxaca.api.v1.follow_up.application;

import mx.edu.itoaxaca.api.v1.follow_up.domain.FollowUp;
import mx.edu.itoaxaca.api.v1.follow_up.domain.FollowUpRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class FollowUpGetAll {
    public static Page<FollowUp> run(Pageable pageable, FollowUpRepository repo) {
        return repo.findAll(pageable);
    }
}
