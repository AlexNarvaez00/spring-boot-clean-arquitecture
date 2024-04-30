package mx.edu.itoaxaca.api.v1.speciality.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.speciality.domain.Speciality;
import mx.edu.itoaxaca.api.v1.speciality.domain.SpecialityRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresSpecialityRepository 
    extends JpaRepository<Speciality, UUID>, SpecialityRepository {}
