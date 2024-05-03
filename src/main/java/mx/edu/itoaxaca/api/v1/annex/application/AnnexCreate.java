package mx.edu.itoaxaca.api.v1.annex.application;

import mx.edu.itoaxaca.api.v1.annex.domain.Annex;
import mx.edu.itoaxaca.api.v1.annex.domain.AnnexRepository;

public class AnnexCreate {
    public static Annex run(AnnexRepository repo, Annex arg) {
        return repo.save(arg);
    }
}
