package mx.edu.itoaxaca.api.v1.period.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.period.domain.Period;
import mx.edu.itoaxaca.api.v1.period.domain.PeriodRepository;

public class PeriodGetById {
    public static Period run(PeriodRepository repo, UUID id) {
        return repo.findPeriodById(id);
    }
}
