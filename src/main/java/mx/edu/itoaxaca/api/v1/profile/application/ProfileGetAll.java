package mx.edu.itoaxaca.api.v1.profile.application;

import mx.edu.itoaxaca.api.v1.profile.domain.Profile;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileRepository;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Criteria;
import mx.edu.itoaxaca.api.v1.shared.infrastructure.JPACriteriaConverter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProfileGetAll {
    public static Page<Profile> run(Pageable pageable, ProfileRepository repo, Criteria criteria) {
        JPACriteriaConverter<Profile> convert = new JPACriteriaConverter<Profile>();
        return repo.findAll(convert.convert(criteria),pageable);
    }
}
