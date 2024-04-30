package mx.edu.itoaxaca.api.v1.shedule.application;

import mx.edu.itoaxaca.api.v1.shedule.domain.Shedule;
import mx.edu.itoaxaca.api.v1.shedule.domain.SheduleRepository;

public class SheduleCreate {
    public static Shedule run(SheduleRepository repo, Shedule arg) {
        return repo.save(arg);
    }
}
