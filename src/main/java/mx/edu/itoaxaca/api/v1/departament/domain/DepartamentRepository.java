package mx.edu.itoaxaca.api.v1.departament.domain;

import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartamentRepository {
    Departament save(Departament departament);
    Page<Departament> findAll(Pageable pageable);
    void deleteById(UUID id);
    Departament findDepartamentById(UUID id);
}
