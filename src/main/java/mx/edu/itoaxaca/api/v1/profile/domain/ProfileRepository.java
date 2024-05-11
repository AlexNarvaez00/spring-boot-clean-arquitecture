package mx.edu.itoaxaca.api.v1.profile.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProfileRepository {
    Profile save(Profile arg);
    Page<Profile> findAll(Pageable pageable);
    void deleteById(UUID id);
    Profile findProfileById(UUID id);
}
