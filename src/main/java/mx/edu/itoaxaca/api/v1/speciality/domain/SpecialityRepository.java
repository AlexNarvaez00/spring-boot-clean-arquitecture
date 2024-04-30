package mx.edu.itoaxaca.api.v1.speciality.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SpecialityRepository {
    Speciality save(Speciality arg);
    Page<Speciality> findAll(Pageable pageable);
    void deleteById(UUID id);
    Speciality findSpecialityById(UUID id);
}
