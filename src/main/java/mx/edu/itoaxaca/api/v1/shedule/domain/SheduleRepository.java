package mx.edu.itoaxaca.api.v1.shedule.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SheduleRepository {
    Shedule save(Shedule arg);
    Page<Shedule> findAll(Pageable pageable);
    void deleteById(UUID id);
    Shedule findSheduleById(UUID id);
}
