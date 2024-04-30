package mx.edu.itoaxaca.api.v1.speciality.application;

import mx.edu.itoaxaca.api.v1.speciality.domain.Speciality;
import mx.edu.itoaxaca.api.v1.speciality.domain.SpecialityRepository;

public class SpecialityCreate {
    public static Speciality run(SpecialityRepository repo, Speciality arg) {
        return repo.save(arg);
    }
}
