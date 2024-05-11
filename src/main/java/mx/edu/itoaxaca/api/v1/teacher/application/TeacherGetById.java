package mx.edu.itoaxaca.api.v1.teacher.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.teacher.domain.Teacher;
import mx.edu.itoaxaca.api.v1.teacher.domain.TeacherRepository;

public class TeacherGetById {
    public static Teacher run(TeacherRepository repo, UUID id) {
        return repo.findTeacherById(id);
    }
}
