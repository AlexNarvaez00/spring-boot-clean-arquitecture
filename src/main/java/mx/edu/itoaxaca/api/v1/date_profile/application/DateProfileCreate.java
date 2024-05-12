package mx.edu.itoaxaca.api.v1.date_profile.application;

import mx.edu.itoaxaca.api.v1.date_profile.domain.DateProfile;
import mx.edu.itoaxaca.api.v1.date_profile.domain.DateProfileRepository;

public class DateProfileCreate {
    public static DateProfile run(DateProfileRepository repo, DateProfile arg) {
        return repo.save(arg);
    }
}
