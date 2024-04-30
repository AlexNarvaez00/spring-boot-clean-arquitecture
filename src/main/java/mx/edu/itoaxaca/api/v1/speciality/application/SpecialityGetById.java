package mx.edu.itoaxaca.api.v1.speciality.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.speciality.domain.Speciality;
import mx.edu.itoaxaca.api.v1.speciality.domain.SpecialityRepository;

public class SpecialityGetById {
    public static Speciality run(SpecialityRepository repo, UUID id) {
        return repo.findSpecialityById(id);
    }
}
