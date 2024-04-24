package mx.edu.itoaxaca.api.v1.workshop.application;

import java.util.UUID;

import mx.edu.itoaxaca.api.v1.workshop.domain.Workshop;
import mx.edu.itoaxaca.api.v1.workshop.domain.WorkshopRepository;

public class WorkshopUpdate {
    public static Workshop run(WorkshopRepository repo, UUID id, Workshop Workshop) {
        Workshop.setId(id);
        return repo.save(Workshop);
    }
}
