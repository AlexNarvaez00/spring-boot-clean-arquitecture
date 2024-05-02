package mx.edu.itoaxaca.api.v1.date.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.date.domain.Date;
import mx.edu.itoaxaca.api.v1.date.domain.DateRepository;

public class DateUpdate {
    public static Date run(
        DateRepository repo,
        UUID id,
        Date arg
    ) {
        arg.setId(id);
        return repo.save(arg);
    }
}
