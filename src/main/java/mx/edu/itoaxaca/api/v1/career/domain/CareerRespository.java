package mx.edu.itoaxaca.api.v1.career.domain;

import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CareerRespository {
    Career save(Career career);
    Page<Career> findAll(Pageable pageable);
    void deleteById(UUID id);
    Career findDepartamentById(UUID id);
}
