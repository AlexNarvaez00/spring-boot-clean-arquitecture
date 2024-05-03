package mx.edu.itoaxaca.api.v1.annex.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.annex.domain.AnnexRepository;

public class AnnexDestroy {
    public static void run(AnnexRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
