package mx.edu.itoaxaca.api.v1.groups.infrastructure.persistences;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.groups.domain.Group;
import mx.edu.itoaxaca.api.v1.groups.domain.GroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresGroupRespository extends JpaRepository<Group, UUID>, GroupRepository {}
