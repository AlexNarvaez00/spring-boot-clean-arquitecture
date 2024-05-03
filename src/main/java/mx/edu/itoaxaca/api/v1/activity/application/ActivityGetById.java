package mx.edu.itoaxaca.api.v1.activity.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.activity.domain.Activity;
import mx.edu.itoaxaca.api.v1.activity.domain.ActivityRepository;

public class ActivityGetById {
    public static Activity run(ActivityRepository repo, UUID id) {
        return repo.findActivityById(id);
    }
}
