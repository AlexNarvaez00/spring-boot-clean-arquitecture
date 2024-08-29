package mx.edu.itoaxaca.api.v1.profile.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileRepository;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Criteria;
import mx.edu.itoaxaca.api.v1.shared.infrastructure.JPACriteriaConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostgresProfileRepository
    extends
        JpaRepository<Profile, UUID>,
        JpaSpecificationExecutor<Profile>,
        ProfileRepository {
    @Override
    default Page<Profile> byCriteria(Criteria criteria) {
        JPACriteriaConverter<Profile> converter = new JPACriteriaConverter<
            Profile
        >();
        PageRequest pageable = PageRequest.of(
            criteria.offset(),
            criteria.limit()
        );
        return this.findAll(converter.convert(criteria), pageable);
    }
}
