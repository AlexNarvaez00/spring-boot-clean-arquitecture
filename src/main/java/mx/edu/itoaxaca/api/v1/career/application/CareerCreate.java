package mx.edu.itoaxaca.api.v1.career.application;

import mx.edu.itoaxaca.api.v1.career.domain.Career;
import mx.edu.itoaxaca.api.v1.career.domain.CareerRespository;

public class CareerCreate {

    public static Career run(CareerRespository respository, Career career) {
        return respository.save(career);
    }
}
