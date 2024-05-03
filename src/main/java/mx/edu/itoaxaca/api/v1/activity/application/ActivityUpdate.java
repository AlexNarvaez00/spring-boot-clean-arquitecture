package mx.edu.itoaxaca.api.v1.activity.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.activity.domain.Activity;
import mx.edu.itoaxaca.api.v1.activity.domain.ActivityRepository;

public class ActivityUpdate {
    public static Activity run(
        ActivityRepository repo,
        UUID id,
        Activity arg
    ) {
        arg.setId(id);
        return repo.save(arg);
    }
}
