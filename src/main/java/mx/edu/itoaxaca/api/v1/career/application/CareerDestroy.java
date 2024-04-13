package mx.edu.itoaxaca.api.v1.career.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.career.domain.CareerRespository;

public class CareerDestroy {

    public static void run(CareerRespository respository, UUID id) {
        respository.deleteById(id);
    }
}
