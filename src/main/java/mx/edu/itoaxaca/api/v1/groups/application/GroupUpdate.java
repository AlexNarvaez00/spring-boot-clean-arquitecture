package mx.edu.itoaxaca.api.v1.groups.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.groups.domain.Group;
import mx.edu.itoaxaca.api.v1.groups.domain.GroupRepository;

public class GroupUpdate {

    public static Group run(GroupRepository repo, UUID id, Group group) {
        Group groupFromDataBase = repo.findGroupById(id);
        group.setId(id);
        group.setCreatedAt(groupFromDataBase.getCreatedAt());
        return repo.save(group);
    }
}
