package mx.edu.itoaxaca.api.v1.speciality.application;

import mx.edu.itoaxaca.api.v1.speciality.domain.Speciality;
import mx.edu.itoaxaca.api.v1.speciality.domain.SpecialityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class SpecialityGetAll {
    public static Page<Speciality> run(Pageable pageable, SpecialityRepository repo) {
        return repo.findAll(pageable);
    }
}
