package mx.edu.itoaxaca.api.v1.date_profile.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.date_profile.domain.DateProfile;
import mx.edu.itoaxaca.api.v1.date_profile.domain.DateProfileRepository;

public class DateProfileGetById {
    public static DateProfile run(DateProfileRepository repo, UUID id) {
        return repo.findDateProfileById(id);
    }
}
