package mx.edu.itoaxaca.api.v1.support_area.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SupportAreaRepository {
    SupportArea save(SupportArea supportArea);
    Page<SupportArea> findAll(Pageable pageable);
    void deleteById(UUID id);
    SupportArea findSupportAreaById(UUID id);
}
