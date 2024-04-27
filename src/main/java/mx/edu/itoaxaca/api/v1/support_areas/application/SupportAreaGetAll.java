package mx.edu.itoaxaca.api.v1.support_areas.application;

import mx.edu.itoaxaca.api.v1.support_areas.domain.SupportArea;
import mx.edu.itoaxaca.api.v1.support_areas.domain.SupportAreaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class SupportAreaGetAll {

    public static Page<SupportArea> run(Pageable pageable, SupportAreaRepository repo) {
        return repo.findAll(pageable);
    }
}
