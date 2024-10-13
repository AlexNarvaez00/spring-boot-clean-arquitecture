package mx.edu.itoaxaca.api.v1.groups.infrastructure.persistences;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.groups.domain.Group;
import mx.edu.itoaxaca.api.v1.groups.domain.GroupRepository;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Criteria;
import mx.edu.itoaxaca.api.v1.shared.infrastructure.JPACriteriaConverter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostgresGroupRespository
    extends JpaRepository<Group, UUID>, JpaSpecificationExecutor<Group> ,GroupRepository {
    default Page<Group> findByCriteria(Criteria criteria, Pageable pageable) {
        JPACriteriaConverter<Group> converter = new JPACriteriaConverter<
            Group
        >();
        return this.findAll(converter.convert(criteria), pageable);
    }
}
