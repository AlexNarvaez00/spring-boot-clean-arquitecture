package mx.edu.itoaxaca.api.v1.annex.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.annex.domain.Annex;
import mx.edu.itoaxaca.api.v1.annex.domain.AnnexRepository;

public class AnnexGetById {
    public static Annex run(AnnexRepository repo, UUID id) {
        return repo.findAnnexById(id);
    }
}
