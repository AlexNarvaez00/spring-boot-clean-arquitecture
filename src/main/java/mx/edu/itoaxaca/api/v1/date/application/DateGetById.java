package mx.edu.itoaxaca.api.v1.date.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.date.domain.Date;
import mx.edu.itoaxaca.api.v1.date.domain.DateRepository;

public class DateGetById {
    public static Date run(DateRepository repo, UUID id) {
        return repo.findDateById(id);
    }
}
