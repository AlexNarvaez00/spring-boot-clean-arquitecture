package mx.edu.itoaxaca.api.v1.workshop.application;

import mx.edu.itoaxaca.api.v1.workshop.domain.Workshop;
import mx.edu.itoaxaca.api.v1.workshop.domain.WorkshopRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class WorkshopGretAll {

    public static Page<Workshop> run(Pageable pageable, WorkshopRepository repo) {
        return repo.findAll(pageable);
    }
}
