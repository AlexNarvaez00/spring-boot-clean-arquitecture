package mx.edu.itoaxaca.api.v1.date.application;

import mx.edu.itoaxaca.api.v1.date.domain.Date;
import mx.edu.itoaxaca.api.v1.date.domain.DateRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class DateGetAll {
    public static Page<Date> run(Pageable pageable, DateRepository repo) {
        return repo.findAll(pageable);
    }
}
