package mx.edu.itoaxaca.api.v1.groups.application;

import mx.edu.itoaxaca.api.v1.groups.domain.Group;
import mx.edu.itoaxaca.api.v1.groups.domain.GroupRepository;

public class GroupCreate {

    public static Group run(GroupRepository repository, Group group) {
        return repository.save(group);
    }
}
