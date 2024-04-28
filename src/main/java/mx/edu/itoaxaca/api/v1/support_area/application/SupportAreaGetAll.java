package mx.edu.itoaxaca.api.v1.support_area.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.edu.itoaxaca.api.v1.support_area.domain.SupportArea;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportAreaRepository;

public class SupportAreaGetAll {

    public static Page<SupportArea> run(Pageable pageable, SupportAreaRepository repo) {
        return repo.findAll(pageable);
    }
}
