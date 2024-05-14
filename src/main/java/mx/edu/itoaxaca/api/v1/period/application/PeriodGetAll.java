package mx.edu.itoaxaca.api.v1.period.application;

import mx.edu.itoaxaca.api.v1.period.domain.Period;
import mx.edu.itoaxaca.api.v1.period.domain.PeriodRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PeriodGetAll {
    public static Page<Period> run(Pageable pageable, PeriodRepository repo) {
        return repo.findByDeletedAtIsNull(pageable);
    }
}
