package mx.edu.itoaxaca.api.v1.shedule.application;

import mx.edu.itoaxaca.api.v1.shedule.domain.Shedule;
import mx.edu.itoaxaca.api.v1.shedule.domain.SheduleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class SheduleGetAll {
    public static Page<Shedule> run(Pageable pageable, SheduleRepository repo) {
        return repo.findAll(pageable);
    }
}
