package mx.edu.itoaxaca.api.v1.annex.application;

import mx.edu.itoaxaca.api.v1.annex.domain.Annex;
import mx.edu.itoaxaca.api.v1.annex.domain.AnnexRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class AnnexGetAll {
    public static Page<Annex> run(Pageable pageable, AnnexRepository repo) {
        return repo.findAll(pageable);
    }
}
