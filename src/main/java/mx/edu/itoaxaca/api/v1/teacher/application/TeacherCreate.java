package mx.edu.itoaxaca.api.v1.teacher.application;

import mx.edu.itoaxaca.api.v1.teacher.domain.Teacher;
import mx.edu.itoaxaca.api.v1.teacher.domain.TeacherRepository;

public class TeacherCreate {
    public static Teacher run(TeacherRepository repo, Teacher arg) {
        return repo.save(arg);
    }
}
