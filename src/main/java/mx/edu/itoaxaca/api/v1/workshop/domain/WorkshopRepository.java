package mx.edu.itoaxaca.api.v1.workshop.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WorkshopRepository {
    Workshop save(Workshop workshop);
    Page<Workshop> findAll(Pageable pageable);
    void deleteById(UUID id);
    Workshop findWorkshopById(UUID id);
}
