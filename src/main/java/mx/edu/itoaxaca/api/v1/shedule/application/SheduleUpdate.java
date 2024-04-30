package mx.edu.itoaxaca.api.v1.shedule.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shedule.domain.Shedule;
import mx.edu.itoaxaca.api.v1.shedule.domain.SheduleRepository;

public class SheduleUpdate {
    public static Shedule run(
        SheduleRepository repo,
        UUID id,
        Shedule arg
    ) {
        arg.setId(id);
        return repo.save(arg);
    }
}
