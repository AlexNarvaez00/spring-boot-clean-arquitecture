package mx.edu.itoaxaca.api.v1.groups.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.groups.domain.Group;
import mx.edu.itoaxaca.api.v1.groups.domain.GroupRepository;

public class GroupGetById {

    public static Group run(GroupRepository repo, UUID id) {
        return repo.findGroupById(id);
    }
}
