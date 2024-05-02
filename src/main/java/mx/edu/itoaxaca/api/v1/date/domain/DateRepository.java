package mx.edu.itoaxaca.api.v1.date.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DateRepository {
    Date save(Date arg);
    Page<Date> findAll(Pageable pageable);
    void deleteById(UUID id);
    Date findDateById(UUID id);
}
