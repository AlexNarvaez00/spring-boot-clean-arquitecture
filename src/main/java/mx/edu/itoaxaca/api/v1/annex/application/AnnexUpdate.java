package mx.edu.itoaxaca.api.v1.annex.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.annex.domain.Annex;
import mx.edu.itoaxaca.api.v1.annex.domain.AnnexRepository;

public class AnnexUpdate {
    public static Annex run(
        AnnexRepository repo,
        UUID id,
        Annex arg
    ) {
        arg.setId(id);
        return repo.save(arg);
    }
}
