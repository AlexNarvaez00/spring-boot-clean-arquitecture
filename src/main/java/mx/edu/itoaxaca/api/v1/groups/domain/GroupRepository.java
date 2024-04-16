package mx.edu.itoaxaca.api.v1.groups.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GroupRepository {
    Group save(Group group);
    Page<Group> findAll(Pageable pageable);
    void deleteById(UUID id);
    Group findGroupById(UUID id);
}
