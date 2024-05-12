package mx.edu.itoaxaca.api.v1.group_tutor_student.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.group_tutor_student.domain.GroupTutorStudent;
import mx.edu.itoaxaca.api.v1.group_tutor_student.domain.GroupTutorStudentRepository;

public class GroupTutorStudentUpdate {
    public static GroupTutorStudent run(
        GroupTutorStudentRepository repo,
        UUID id,
        GroupTutorStudent arg
    ) {
        arg.setId(id);
        return repo.save(arg);
    }
}
