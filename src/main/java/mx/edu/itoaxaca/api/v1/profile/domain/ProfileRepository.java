package mx.edu.itoaxaca.api.v1.profile.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Criteria;

public interface ProfileRepository{
    Profile save(Profile arg);
    Page<Profile> findAll(Pageable pageable);
    Page<Profile> findByEmailLike(Pageable pageable, ProfileEmail email);
    void deleteById(UUID id);
    Profile findProfileById(UUID id);
    Page<Profile> byCriteria(Criteria criteria);
}
