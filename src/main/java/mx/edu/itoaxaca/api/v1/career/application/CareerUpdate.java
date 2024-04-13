package mx.edu.itoaxaca.api.v1.career.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.career.domain.Career;
import mx.edu.itoaxaca.api.v1.career.domain.CareerRespository;

public class CareerUpdate {

    public static Career run(CareerRespository repo, UUID id, Career career) {
        career.setId(id);
        return repo.save(career);
    }
}
