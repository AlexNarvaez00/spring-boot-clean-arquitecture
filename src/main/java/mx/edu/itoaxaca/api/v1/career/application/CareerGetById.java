package mx.edu.itoaxaca.api.v1.career.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.career.domain.Career;
import mx.edu.itoaxaca.api.v1.career.domain.CareerRespository;

public class CareerGetById {

    public static Career run(CareerRespository respository, UUID id) {
        return respository.findCareerById(id);
    }
}
