package mx.edu.itoaxaca.api.v1.activity.application;

import mx.edu.itoaxaca.api.v1.activity.domain.Activity;
import mx.edu.itoaxaca.api.v1.activity.domain.ActivityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ActivityGetAll {
    public static Page<Activity> run(Pageable pageable, ActivityRepository repo) {
        return repo.findAll(pageable);
    }
}
