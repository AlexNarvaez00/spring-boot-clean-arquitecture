package mx.edu.itoaxaca.api.v1.groups.application;

import mx.edu.itoaxaca.api.v1.groups.domain.Group;
import mx.edu.itoaxaca.api.v1.groups.domain.GroupRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class GroupGetAll {

    public static Page<Group> run(Pageable pageable, GroupRepository repo) {
        return repo.findAll(pageable);
    }
}
