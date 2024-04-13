package mx.edu.itoaxaca.api.v1.career.application;

import mx.edu.itoaxaca.api.v1.career.domain.Career;
import mx.edu.itoaxaca.api.v1.career.domain.CareerRespository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CareerGetAll {

    public static Page<Career> run(Pageable pageable, CareerRespository repos) {
        return repos.findAll(pageable);
    }
}
