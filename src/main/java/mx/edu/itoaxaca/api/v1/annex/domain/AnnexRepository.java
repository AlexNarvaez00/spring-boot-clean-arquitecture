package mx.edu.itoaxaca.api.v1.annex.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnnexRepository {
    Annex save(Annex arg);
    Page<Annex> findAll(Pageable pageable);
    void deleteById(UUID id);
    Annex findAnnexById(UUID id);
}
