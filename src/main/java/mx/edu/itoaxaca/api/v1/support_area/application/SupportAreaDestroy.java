package mx.edu.itoaxaca.api.v1.support_area.application;

import java.util.UUID;

import mx.edu.itoaxaca.api.v1.support_area.domain.SupportAreaRepository;

public class SupportAreaDestroy {

    public static void run(SupportAreaRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
