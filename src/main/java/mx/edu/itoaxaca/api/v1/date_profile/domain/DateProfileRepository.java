package mx.edu.itoaxaca.api.v1.date_profile.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DateProfileRepository {
    DateProfile save(DateProfile arg);
    Page<DateProfile> findAll(Pageable pageable);
    void deleteById(UUID id);
    DateProfile findDateProfileById(UUID id);
}
