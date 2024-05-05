package mx.edu.itoaxaca.api.v1.follow_up.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FollowUpRepository {
    FollowUp save(FollowUp arg);
    Page<FollowUp> findAll(Pageable pageable);
    void deleteById(UUID id);
    FollowUp findFollowUpById(UUID id);
}
