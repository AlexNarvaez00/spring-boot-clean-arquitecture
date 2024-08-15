package mx.edu.itoaxaca.api.v1.profile.application;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileRepository;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Criteria;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Filters;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Limit;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Operator;
import mx.edu.itoaxaca.api.v1.shared.infrastructure.JPACriteriaConverter;

public class ProfileGetById {

    public static Profile run(ProfileRepository repo, UUID id) {
        Map<String, String> byId = new HashMap<String, String>();
        byId.put("field", "id");
        byId.put("operator", Operator.EQUALS.value());
        byId.put("value", id.toString());
        Map<String, String>[] filters = new Map[] { byId };

        Criteria criteria = new Criteria(
            Filters.fromValues(filters),
            new Limit(0)
        );

        JPACriteriaConverter<Profile> converter = new JPACriteriaConverter<
            Profile
        >();
        var results = repo.findAll(converter.convert(criteria));

        return results.get(0);
    }
}
