package mx.edu.itoaxaca.api.v1.group_tutor_student.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.group_tutor_student.domain.GroupTutorStudentRepository;

public class GroupTutorStudentDestroy {
    public static void run(GroupTutorStudentRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
