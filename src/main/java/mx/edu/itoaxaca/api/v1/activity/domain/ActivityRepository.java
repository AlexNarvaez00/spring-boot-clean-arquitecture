package mx.edu.itoaxaca.api.v1.activity.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ActivityRepository {
    Activity save(Activity arg);
    Page<Activity> findAll(Pageable pageable);
    void deleteById(UUID id);
    Activity findActivityById(UUID id);
}
