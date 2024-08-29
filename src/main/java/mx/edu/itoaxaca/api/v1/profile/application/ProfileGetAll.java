package mx.edu.itoaxaca.api.v1.profile.application;

import mx.edu.itoaxaca.api.v1.profile.domain.Profile;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileRepository;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Criteria;

import org.springframework.data.domain.Page;

public class ProfileGetAll {
    public static Page<Profile> run(ProfileRepository repo, Criteria criteria) {
        return repo.byCriteria(criteria);
    }
}
