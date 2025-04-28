package mx.edu.itoaxaca.api.v1.profile.application;

import mx.edu.itoaxaca.api.v1.profile.domain.Profile;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileRepository;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Criteria;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Filters;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Limit;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Operator;
import mx.edu.itoaxaca.api.v1.shared.infrastructure.hibernate.HibernateCriteriaConverter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProfileGetByEmail {
    public static Page<Profile> run(Pageable pageable, ProfileRepository repo, String email) {
        Map<String, String> byId = new HashMap<String, String>();
        byId.put("field", "email");
        byId.put("operator", Operator.INCLUDE.toString());
        byId.put("value",email);
        Map<String, String>[] filters = new Map[] { byId };

        Criteria criteria = new Criteria(Filters.fromValues(filters), new Limit(10));

        HibernateCriteriaConverter<Profile> converter = new HibernateCriteriaConverter<Profile>();

        var results = repo.findAll( converter.convert(criteria), pageable);
        return results;
    }
}
