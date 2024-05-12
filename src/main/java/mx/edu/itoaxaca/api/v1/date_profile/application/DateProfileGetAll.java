package mx.edu.itoaxaca.api.v1.date_profile.application;

import mx.edu.itoaxaca.api.v1.date_profile.domain.DateProfile;
import mx.edu.itoaxaca.api.v1.date_profile.domain.DateProfileRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class DateProfileGetAll {
    public static Page<DateProfile> run(Pageable pageable, DateProfileRepository repo) {
        return repo.findAll(pageable);
    }
}
