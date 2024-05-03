package mx.edu.itoaxaca.api.v1.activity.application;

import mx.edu.itoaxaca.api.v1.activity.domain.Activity;
import mx.edu.itoaxaca.api.v1.activity.domain.ActivityRepository;

public class ActivityCreate {
    public static Activity run(ActivityRepository repo, Activity arg) {
        return repo.save(arg);
    }
}
