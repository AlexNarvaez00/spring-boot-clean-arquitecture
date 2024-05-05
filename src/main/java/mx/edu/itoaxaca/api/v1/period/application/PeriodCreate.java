package mx.edu.itoaxaca.api.v1.period.application;

import mx.edu.itoaxaca.api.v1.period.domain.Period;
import mx.edu.itoaxaca.api.v1.period.domain.PeriodRepository;

public class PeriodCreate {
    public static Period run(PeriodRepository repo, Period arg) {
        return repo.save(arg);
    }
}
