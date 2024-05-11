package mx.edu.itoaxaca.api.v1.teacher.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.teacher.domain.Teacher;
import mx.edu.itoaxaca.api.v1.teacher.domain.TeacherRepository;

public class TeacherUpdate {
    public static Teacher run(
        TeacherRepository repo,
        UUID id,
        Teacher arg
    ) {
        arg.setId(id);
        return repo.save(arg);
    }
}
