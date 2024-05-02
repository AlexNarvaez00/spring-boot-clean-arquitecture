package mx.edu.itoaxaca.api.v1.date.application;

import mx.edu.itoaxaca.api.v1.date.domain.Date;
import mx.edu.itoaxaca.api.v1.date.domain.DateRepository;

public class DateCreate {
    public static Date run(DateRepository repo, Date arg) {
        return repo.save(arg);
    }
}
