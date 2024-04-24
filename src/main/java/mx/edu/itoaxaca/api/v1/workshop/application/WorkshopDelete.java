package mx.edu.itoaxaca.api.v1.workshop.application;

import java.util.UUID;

import mx.edu.itoaxaca.api.v1.workshop.domain.WorkshopRepository;

public class WorkshopDelete {
    public static void run(WorkshopRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
