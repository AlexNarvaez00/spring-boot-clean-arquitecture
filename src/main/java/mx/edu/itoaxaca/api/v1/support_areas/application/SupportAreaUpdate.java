package mx.edu.itoaxaca.api.v1.support_areas.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.support_areas.domain.SupportArea;
import mx.edu.itoaxaca.api.v1.support_areas.domain.SupportAreaRepository;

public class SupportAreaUpdate {

    public static SupportArea run(
        SupportAreaRepository repo,
        UUID id,
        SupportArea supportArea
    ) {
        supportArea.setId(id);
        return repo.save(supportArea);
    }
}
