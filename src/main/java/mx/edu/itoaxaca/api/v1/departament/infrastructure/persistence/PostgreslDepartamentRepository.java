package mx.edu.itoaxaca.api.v1.departament.infrastructure.persistence;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import mx.edu.itoaxaca.api.v1.departament.domain.Departament;
import mx.edu.itoaxaca.api.v1.departament.domain.DepartamentRepository;

@Service
public interface PostgreslDepartamentRepository
    extends JpaRepository<Departament, UUID>, DepartamentRepository {}
