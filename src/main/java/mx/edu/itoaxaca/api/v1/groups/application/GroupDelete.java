package mx.edu.itoaxaca.api.v1.groups.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.groups.domain.GroupRepository;

public class GroupDelete {

    public static void run(GroupRepository repository, UUID id) {
        repository.deleteById(id);
    }
}
