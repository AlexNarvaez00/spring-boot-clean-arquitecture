package mx.edu.itoaxaca.api.v1.channeling.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChannellingRepository {
    Channelling save(Channelling arg);
    Page<Channelling> findAll(Pageable pageable);
    void deleteById(UUID id);
    Channelling findChannellingById(UUID id);
}
