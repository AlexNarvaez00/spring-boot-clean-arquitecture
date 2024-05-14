package mx.edu.itoaxaca.api.v1.period.application;

import java.time.LocalDateTime;
import java.util.UUID;
import mx.edu.itoaxaca.api.v1.period.domain.PeriodRepository;
import mx.edu.itoaxaca.api.v1.shared.domain.DeletedAt;

public class PeriodDestroy {

    public static void run(PeriodRepository repo, UUID id) {
        var periodTodeleted = repo.findPeriodById(id);
        periodTodeleted.setDeletedAt(new DeletedAt(LocalDateTime.now()));
        repo.save(periodTodeleted);
    }
}
