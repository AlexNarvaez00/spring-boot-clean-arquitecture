package mx.edu.itoaxaca.api.v1.workshop.application;

import mx.edu.itoaxaca.api.v1.workshop.domain.Workshop;
import mx.edu.itoaxaca.api.v1.workshop.domain.WorkshopRepository;

public class WorkshopCreate {

    public static Workshop run(WorkshopRepository repo, Workshop workshop) {
        return repo.save(workshop);
    }
}
