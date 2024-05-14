package mx.edu.itoaxaca.api.v1.period.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PeriodRepository {
    Period save(Period arg);
    Page<Period> findAll(Pageable pageable);
    void deleteById(UUID id);
    Period findPeriodById(UUID id);
    Page<Period> findByDeletedAtIsNull(Pageable pageable);
}
